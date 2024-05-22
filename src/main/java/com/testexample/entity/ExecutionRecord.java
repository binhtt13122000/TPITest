package com.testexample.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "execution_record")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ExecutionRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serno", nullable = false)
    private Long id;

    @Column(name = "servicename", nullable = false, length = 127)
    private String serviceName;

    @Column(name = "msgid", nullable = false, length = 63)
    private String msgId;

    @Column(name = "requestpayload", nullable = false, length = 65535)
    private String requestPayload;

    @Column(name = "request_timestamp", nullable = false)
    private Instant requestTimestamp;
}