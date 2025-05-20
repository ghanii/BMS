package com.ghani.bms.service;

import com.ghani.bms.exception.TheaterNotFoundException;
import com.ghani.bms.model.Theater;
import com.ghani.bms.repository.TheaterRepository;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    private TheaterRepository theaterRepository;

    public TheaterService(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    public Theater saveTheater(Theater theater) {
       return theaterRepository.save(theater);
    }

    public Theater getTheaterById(long theaterId) {
        return theaterRepository.findById(theaterId).orElseThrow(()->new TheaterNotFoundException("Theater not found for id : "+theaterId));
    }
}
