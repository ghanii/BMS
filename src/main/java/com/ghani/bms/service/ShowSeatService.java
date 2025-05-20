package com.ghani.bms.service;

import com.ghani.bms.exception.ShowSeatNotFoundException;
import com.ghani.bms.model.ShowSeat;
import com.ghani.bms.repository.SeatRepository;
import com.ghani.bms.repository.ShowSeatRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowSeatService {

    private ShowSeatRepository showSeatRepository;

    public ShowSeatService(ShowSeatRepository showSeatRepository) {
        this.showSeatRepository = showSeatRepository;
    }

    public ShowSeat createShowSheet(ShowSeat showSeat) {
        return showSeatRepository.save(showSeat);
    }

    public ShowSeat findShowSeatById(long id) {
        return showSeatRepository.findById(id).orElseThrow(()->new ShowSeatNotFoundException("ShowSeat not found for id : "+id));
    }

    public ShowSeat updateShowSeat(ShowSeat showSeat) {
        Optional<ShowSeat> showSeatOptional = showSeatRepository.findById(showSeat.getId());
        ShowSeat oldShowSeat = null;
        if(showSeatOptional.isPresent()) {
            oldShowSeat = showSeatOptional.get();
        }
        oldShowSeat.setShowSeatStatus(showSeat.getShowSeatStatus());
        return showSeatRepository.save(oldShowSeat);
    }
}
