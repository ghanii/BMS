package com.ghani.bms.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Payment extends BaseClass{
    LocalDateTime paymentTime;
    double amount;
    String paymentReference;
}
