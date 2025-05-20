package com.ghani.bms.service;

import com.ghani.bms.model.*;
import com.ghani.bms.model.constant.AuditoriumFeature;
import com.ghani.bms.model.constant.SeatStatus;
import com.ghani.bms.model.constant.SeatType;
import com.ghani.bms.model.constant.ShowStatus;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitializeService {

    private AuditoriumService auditoriumService;
    private TheaterService theaterService;
    private CityService cityService;
    private MovieService movieService;
    private SeatService seatService;
    private ShowService showService;

    public InitializeService(AuditoriumService auditoriumService, TheaterService theaterService, CityService cityService, MovieService movieService, SeatService seatService, ShowService showService) {
        this.auditoriumService = auditoriumService;
        this.theaterService = theaterService;
        this.cityService = cityService;
        this.movieService = movieService;
        this.seatService = seatService;
        this.showService = showService;
    }

    public void initialize() {
        /***
         * TASK TO INITIALIZE data
         * 1. create list of seats
         * 2. those seats are available in Auditorium so set in Auditorium
         * 3.then we can have a theater where we inject this Auditorium
         * 4. then we can create a city where we will inject this List of theaters
         * 5. We can create a show
         * 6. we can create a Movie
         */

        List<Seat> seats = new ArrayList<>();
        for(int i = 1; i <= 100; i++) {
            Seat seat = new Seat();
            seat.setSeatNumber(String.valueOf(i));
            seat.setSeatStatus(SeatStatus.AVAILABLE);
            seat.setSeatType(SeatType.GOLD);
            seatService.createSeat(seat);
            seats.add(seat);
        }

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Auditorium - 1");
        auditorium.setSeats(seats);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.THREE_D,AuditoriumFeature.IMAX));
        auditoriumService.save(auditorium);

        Theater theater = new Theater();
        theater.setName("Theater - 1");
        theater.setAddress("bangalore");
        theater.setAuditoriums(List.of(auditorium));
        theaterService.saveTheater(theater);

        City city = new City();
        city.setName("City - 1");
        city.setTheaters(List.of(theater));
        cityService.createCity(city);

        Movie movie = new Movie();
        movie.setName("spiderMan Chala Bihar");
        movie.setLanguage("English");
        movieService.saveMovie(movie);

        Show show = new Show();
        show.setShowName("Show - 1");
        show.setAuditorium(auditorium);
        show.setMovie(movie);
        show.setLanguage("English");
        show.setShowStatus(ShowStatus.YET_TO_START);
        show.setStartTime(LocalDateTime.now().plusDays(2));
        show.setEndTime(LocalDateTime.now().plusDays(3));
        showService.createShow(show);





    }
}
