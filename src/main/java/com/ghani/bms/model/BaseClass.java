package com.ghani.bms.model;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class BaseClass {
    @Id
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
