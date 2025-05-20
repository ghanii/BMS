package com.ghani.bms.model;

import com.ghani.bms.model.constant.AuditoriumFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Auditorium extends BaseClass{
    private String name;
    @OneToMany
    private List<Seat> seats;
    @OneToMany
    private List<Show> shows;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    List<AuditoriumFeature> auditoriumFeatures;

}
