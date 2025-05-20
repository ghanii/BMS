package com.ghani.bms.controller;

import com.ghani.bms.model.Ticket;
import com.ghani.bms.request.TicketRequest;
import com.ghani.bms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping
    public Ticket createTicket(@RequestBody TicketRequest ticketRequest){
        return ticketService.createTicket(ticketRequest.getUserId(), ticketRequest.getShowSeatIds());
    }
}
