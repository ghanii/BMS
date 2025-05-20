package com.ghani.bms.model;

import com.ghani.bms.model.constant.SeatStatus;
import com.ghani.bms.model.constant.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseClass{
    private String seatNumber;
    private int rowNumber1;
    private int colNumber1;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}
