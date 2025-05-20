package com.ghani.bms.repository;

import com.ghani.bms.model.City;
import com.ghani.bms.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
