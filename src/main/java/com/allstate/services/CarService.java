package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.repositories.ICarRepository;
import com.allstate.repositories.IDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    ICarRepository carRepository;
    @Autowired

    public void setCarRepository(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    IDriverRepository driverRepository;
    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }



    public Car create(Car car){
        return this.carRepository.save(car);

    }
    public List<Car> findByName(String make){
        return this.carRepository.findByMake(make);
    }
    public Car findById(int id){
        return this.carRepository.findOne(id);
    }
    public Driver findDriver(int id){
        Car car = this.carRepository.findOne(id);
        return car.getDriver();

    }
    public List<Trip> findAllTripsAssociatedWithCar(int id){
        return  this.carRepository.findOne(1).getTrips();
    }
}
