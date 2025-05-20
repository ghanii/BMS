package com.ghani.bms.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Movie extends BaseClass{
    private String name;
    private String language;
}
