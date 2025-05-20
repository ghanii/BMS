package com.ghani.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseClass{
    String name;
    @OneToMany
    List<Theater> theaters;
}
