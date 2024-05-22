package com.testexample.service;

import com.testexample.dto.ExecutionRecordDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExecutionRecordService {
    Page<ExecutionRecordDto> findAll(Pageable pageable);

    ExecutionRecordDto findById(long id);

    ExecutionRecordDto create(ExecutionRecordDto executionRecordDto);

    ExecutionRecordDto update(ExecutionRecordDto executionRecordDto);

    boolean delete(long id);

}
