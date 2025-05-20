package com.ghani.bms.model;

import com.ghani.bms.model.constant.ShowStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "bms_show")
public class Show extends BaseClass{
    private String showName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String language;
    @OneToMany
    private List<ShowSeat> showSeats;
    @OneToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @Enumerated(EnumType.STRING)
    private ShowStatus showStatus;
}
