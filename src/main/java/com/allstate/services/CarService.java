package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Passenger;
import com.allstate.repositories.ICarRepository;
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
    public Car create(Car car){
        return this.carRepository.save(car);

    }
    public List<Car> findByName(String make){
        return this.carRepository.findByMake(make);
    }
}
