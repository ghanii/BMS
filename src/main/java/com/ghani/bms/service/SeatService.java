package com.ghani.bms.service;

import com.ghani.bms.exception.SeatNotFoundException;
import com.ghani.bms.model.Seat;
import com.ghani.bms.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public Seat createSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    public Seat findSeatById(long seatId) {
        return seatRepository.findById(seatId).orElseThrow(()->new SeatNotFoundException("Seat not found for id : "+seatId));
    }

    public void deleteSeat(long seatId) {
        seatRepository.deleteById(seatId);
    }

    public List<Seat> findAllSeats() {
        return seatRepository.findAll();
    }

}
