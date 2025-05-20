package com.ghani.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseClass{
    private String name;
    private String address;
    @OneToMany
    List<Auditorium> auditoriums;

}

//Theater -> Auditorium
// 1 -> M
// 1 <-   1
