package com.ghani.bms.service;

import com.ghani.bms.exception.AuditoriumNotFoundException;
import com.ghani.bms.model.Auditorium;
import com.ghani.bms.repository.AuditoriumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService {

    private AuditoriumRepository auditoriumRepository;

    public AuditoriumService(AuditoriumRepository auditoriumRepository) {
        this.auditoriumRepository = auditoriumRepository;
    }

    public Auditorium save(Auditorium auditorium) {
        return auditoriumRepository.save(auditorium);
    }

    public Auditorium findById(long id) {
        return auditoriumRepository.findById(id).orElseThrow(()->new AuditoriumNotFoundException("Auditorium not found for id : "+id));
    }

    public List<Auditorium> findAll() {
        return auditoriumRepository.findAll();
    }

    public void delete(long id) {
        auditoriumRepository.deleteById(id);
    }
}
