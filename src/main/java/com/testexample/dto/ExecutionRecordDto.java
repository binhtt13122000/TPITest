package com.testexample.dto;

import com.testexample.entity.ExecutionRecord;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExecutionRecordDto {
    private Long id;
    private String serviceName;
    private String msgId;
    private String requestPayload;
    private Instant requestTimestamp;

    public static ExecutionRecordDto fromDomain(ExecutionRecord executionRecord) {
        return ExecutionRecordDto
                .builder()
                .id(executionRecord.getId())
                .serviceName(executionRecord.getServiceName())
                .msgId(executionRecord.getMsgId())
                .requestPayload(executionRecord.getRequestPayload())
                .requestTimestamp(executionRecord.getRequestTimestamp())
                .build();
    }
}
