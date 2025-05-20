package com.ghani.bms.service;

import com.ghani.bms.exception.ShowNotFoundException;
import com.ghani.bms.model.Seat;
import com.ghani.bms.model.Show;
import com.ghani.bms.model.ShowSeat;
import com.ghani.bms.model.constant.ShowSeatStatus;
import com.ghani.bms.repository.ShowRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    private final ShowRepository showRepository;
    private final ShowSeatService showSeatService;

    public ShowService(ShowRepository showRepository, ShowSeatService showSeatService) {
        this.showRepository = showRepository;
        this.showSeatService = showSeatService;
    }

    public Show createShow(Show show) {

        //TODO -> create some dummy showSeates as well here
        showRepository.save(show);
        List<ShowSeat> showSeats = new ArrayList<>();
        for(Seat seat : show.getAuditorium().getSeats()){
            ShowSeat showSeat = new ShowSeat();
            showSeat.setShow(show);
            showSeat.setSeat(seat);
            showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
            showSeat.setPrice(100);
            showSeatService.createShowSheet(showSeat);
            showSeats.add(showSeat);
        }
        show.setShowSeats(showSeats);
        return showRepository.save(show);
    }

    public List<Show> getAllShows() {
        return showRepository.findAll();
    }
    public Show getShowById(long id) {
        return showRepository.findById(id).orElseThrow(()->new ShowNotFoundException("Show not found for id :"+id));
    }

    public void deleteShowById(long id) {
        showRepository.deleteById(id);
    }
}
