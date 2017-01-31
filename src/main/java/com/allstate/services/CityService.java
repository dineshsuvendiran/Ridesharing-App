package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    ICityRepository cityRepository;
    @Autowired
    public void setCityRepository(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City create(City city){
        return this.cityRepository.save(city);
    }
    public City findByName(String city){
        return this.cityRepository.findByName(city);
    }
    public City findById(int id){
        return this.cityRepository.findOne(id);
    }
    public void delete(int id){
        this.cityRepository.delete(id);
    }
}
