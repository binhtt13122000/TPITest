package com.testexample.controller;

import com.testexample.dto.ExecutionRecordDto;
import com.testexample.exception.ConflictException;
import com.testexample.service.ExecutionRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {
    private final ExecutionRecordService executionRecordService;

    @GetMapping("")
    ResponseEntity<ExecutionRecordDto> saveExecutionRecord() {
        ExecutionRecordDto executionRecordDto = executionRecordService.create(ExecutionRecordDto.builder().serviceName("test").requestPayload("payload").msgId(UUID.randomUUID().toString()).build());
        return ResponseEntity.ok(executionRecordDto);
    }

    @GetMapping("/test")
    ResponseEntity<Void> testAOP() {
        executionRecordService.create(ExecutionRecordDto.builder().serviceName("test").requestPayload("payload").msgId(UUID.randomUUID().toString()).build());
        throw new ConflictException("A");
    }
}
