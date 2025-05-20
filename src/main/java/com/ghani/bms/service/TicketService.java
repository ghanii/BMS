package com.ghani.bms.service;

import com.ghani.bms.exception.SelectedSeatsNotAvailable;
import com.ghani.bms.model.ShowSeat;
import com.ghani.bms.model.Ticket;
import com.ghani.bms.model.User;
import com.ghani.bms.model.constant.ShowSeatStatus;
import com.ghani.bms.model.constant.TicketStatus;
import com.ghani.bms.repository.ShowSeatRepository;
import com.ghani.bms.repository.TicketRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private final UserService userService;
    private TicketRepository ticketRepository;
    private ShowSeatService showSeatService;
    public TicketService(TicketRepository ticketRepository, ShowSeatService showSeatService, UserService userService) {
        this.ticketRepository = ticketRepository;
        this.showSeatService = showSeatService;
        this.userService = userService;
    }

    public Ticket createTicket(Long userId, List<Long> showSeatIds){
        Ticket ticket = new Ticket();
        User user = userService.findUserById(userId);
        List<ShowSeat> showSeats = new ArrayList<>();
        double totalPrice = 0;
        // Checking and locking the seats So that no 2 users able to book same seat at a time
        checkAndLockShowSeats(showSeatIds);

        //TODO : Payment logic should be implemented here
        //TODO: if payment fails then seat status should be changed to AVAILABLE

        for(Long showSeatId : showSeatIds){
            ShowSeat showSeat = showSeatService.findShowSeatById(showSeatId);
            showSeats.add(showSeat);
            totalPrice += showSeat.getPrice();
        }

        ticket.setUser(user);
        ticket.setShowSeats(showSeats);
        ticket.setShow(showSeats.stream().findFirst().get().getShow());
        ticket.setBookingTime(LocalDateTime.now());
        ticket.setTotalCost(totalPrice);
        ticket.setStatus(TicketStatus.BOOKED);
        return ticketRepository.save(ticket);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<ShowSeat> checkAndLockShowSeats(List<Long> showSeatIds){
        List<ShowSeat> showSeats = new ArrayList<>();
        for (Long showSeatId : showSeatIds) {
            ShowSeat showSeat = showSeatService.findShowSeatById(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SelectedSeatsNotAvailable("selected seats not available, please try other seats");
            }
        }

        for (Long showSeatId : showSeatIds) {
            ShowSeat showSeat = showSeatService.findShowSeatById(showSeatId);
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeats.add(showSeat);
            showSeatService.updateShowSeat(showSeat);
        }
        return showSeats;
    }
}
