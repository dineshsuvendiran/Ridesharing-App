package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    IDriverRepository driverRepository;
    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }
    public Driver create(Driver driver){
        return this.driverRepository.save(driver);
    }
    public Driver findByName(String name){
        return this.driverRepository.findByName(name);
    }
    public Driver findById(int id){
        return this.driverRepository.findOne(id);
    }
    public void delete(int id){
        this.driverRepository.delete(id);
    }
    public Driver update(Driver driver){
        //Driver original = driverRepository.findOne(driver.getId());
        return this.driverRepository.save(driver);

    }

    public List<City> findAllcitiesWhereDriverWorks(int id){
        return this.driverRepository.findOne(id).getCities().stream().distinct().collect(Collectors.toList());
    }


    public List<Car> findAllCarsDriverOwns(int id){
        return this.driverRepository.findOne(id).getCars();
    }
    public List<Trip> findAllTripsAssociatedWithDriver(int id){
        return this.driverRepository.findOne(id).getTrips().stream().distinct().collect(Collectors.toList());
    }
}
