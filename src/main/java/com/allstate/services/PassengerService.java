package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.repositories.IPassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerService  {

    IPassengerRepository passengerRepository;
    @Autowired
    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;


    }
    public Passenger create (Passenger passenger){
        return  this.passengerRepository.save(passenger);
    }

    public List<Passenger> findByName(String name){
        return this.passengerRepository.findByName(name);
    }
    public Passenger findById(int id){
        return this.passengerRepository.findOne(id);
    }
    public void delete(int id){
        this.passengerRepository.delete(id);
    }
    public List<Driver> findAllDrivers(int id){
        return this.passengerRepository.findOne(id).getDrivers().stream().distinct().collect(Collectors.toList());
    }
}
