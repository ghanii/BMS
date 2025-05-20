package com.ghani.bms.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updatedAt;
}
