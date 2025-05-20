package com.ghani.bms.service;

import com.ghani.bms.exception.CityNotFoundException;
import com.ghani.bms.model.City;
import com.ghani.bms.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City findCityById(long id) {
        return cityRepository.findById(id).orElseThrow(()-> new CityNotFoundException("City not found for id " + id));
    }

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public City updateCity(City city) {
        return cityRepository.save(city);
    }

    public void deleteCity(long id) {
        cityRepository.deleteById(id);
    }
}
