package com.testexample.service.impl;

import com.testexample.dto.ExecutionRecordDto;
import com.testexample.entity.ExecutionRecord;
import com.testexample.exception.NotFoundException;
import com.testexample.repository.ExecutionRecordRepository;
import com.testexample.service.ExecutionRecordService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExecutionRecordServiceImpl implements ExecutionRecordService {
    private final ExecutionRecordRepository executionRecordRepository;

    @Override
    public Page<ExecutionRecordDto> findAll(Pageable pageable) {
        return executionRecordRepository.findAll(pageable).map(ExecutionRecordDto::fromDomain);
    }

    @Override
    public ExecutionRecordDto findById(long id) {
        Optional<ExecutionRecord> executionRecord = executionRecordRepository.findById(id);
        return executionRecord.map(ExecutionRecordDto::fromDomain).orElse(null);
    }

    @Override
    public ExecutionRecordDto create(ExecutionRecordDto executionRecordDto) {
        ExecutionRecord executionRecord =
                ExecutionRecord
                        .builder()
                        .serviceName(executionRecordDto.getServiceName())
                        .msgId(executionRecordDto.getMsgId())
                        .requestPayload(executionRecordDto.getRequestPayload())
                        .requestTimestamp(Instant.now())
                        .build();
        ExecutionRecord savedExecutionRecord = executionRecordRepository.save(executionRecord);
        log.info("Create ExecutionRecord with Id = {} successfully!", savedExecutionRecord.getId());
        return ExecutionRecordDto.fromDomain(savedExecutionRecord);
    }

    @Override
    public ExecutionRecordDto update(ExecutionRecordDto executionRecordDto) {
        ExecutionRecord savedExecutionRecord = executionRecordRepository.findById(executionRecordDto.getId()).orElse(null);
        if (Objects.isNull(savedExecutionRecord)) {
            log.error("ExecutionRecord with Id = {} is not found!", executionRecordDto.getId());
            throw new NotFoundException();
        }

        savedExecutionRecord.setServiceName(executionRecordDto.getServiceName());
        savedExecutionRecord.setMsgId(executionRecordDto.getMsgId());
        savedExecutionRecord.setRequestPayload(executionRecordDto.getRequestPayload());
        savedExecutionRecord.setRequestTimestamp(executionRecordDto.getRequestTimestamp());

        savedExecutionRecord =  executionRecordRepository.save(savedExecutionRecord);
        log.info("Update ExecutionRecord with Id = {} successfully!", executionRecordDto.getId());
        return ExecutionRecordDto.fromDomain(savedExecutionRecord);
    }

    @Override
    public boolean delete(long id) {
        ExecutionRecord savedExecutionRecord = executionRecordRepository.findById(id).orElse(null);
        if (Objects.isNull(savedExecutionRecord)) {
            log.error("Execution Record with Id = {} is not found!", id);
            return false;
        }

        executionRecordRepository.deleteById(id);
        log.info("Delete ExecutionRecord with Id = {} successfully!", id);
        return true;
    }
}
