package com.ghani.bms.controller;

import com.ghani.bms.model.Ticket;
import com.ghani.bms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Ticket createTicket(int userId, List<Long> showSeatIds){
        return ticketService.createTicket(userId, showSeatIds);
    }
}
