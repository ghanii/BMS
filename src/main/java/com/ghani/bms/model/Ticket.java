package com.ghani.bms.model;

import com.ghani.bms.model.constant.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseClass{
    double totalCost;
    @OneToMany
    List<ShowSeat> showSeats;
    @ManyToOne
    Show show;
    @ManyToOne
    User user;
    LocalDateTime bookingTime;
    @Enumerated(EnumType.STRING)
    TicketStatus status;
}
