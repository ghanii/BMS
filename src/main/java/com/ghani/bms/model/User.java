package com.ghani.bms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseClass{
    private String name;
    private String password;
    String email;
    @OneToMany
    List<Ticket> tickets;
    @OneToMany
    List<Payment> payments;
}
