package com.ghani.bms.repository;

import com.ghani.bms.model.Auditorium;
import com.ghani.bms.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
}
