package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.enums.CarClass;
import com.allstate.repositories.ICarRepository;
import com.allstate.repositories.ITripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService {

    ITripRepository tripRepository;

    @Autowired

    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }





    public Trip createTrip(Trip trip){
         double fare,carClassFare = 0;

         if(trip.getStartTime().getHours()>22 || trip.getStartTime().getHours()<6){
             fare = trip.getCity().getRateperKmNight();
         }
         else
             fare = trip.getCity().getRateperKmDay();

        if(trip.getCar().getCarClass() == CarClass.LUX)
            carClassFare =(5 *fare * trip.getDistance())/100;

        double estimatedCost = fare * trip.getDistance() + ((fare * trip.getDistance())*trip.getTipPercent())/100 +carClassFare ;
        if(!trip.getDriver().getBanned() && estimatedCost<= trip.getPassenger().getCreditBalance()){
             trip.setCost(fare * trip.getDistance());

             trip.setTotalCost(estimatedCost);
             long diff = trip.getStartTime().getTime() - trip.getEndTime().getTime();
             long diffMinutes = diff / (60 * 1000) % 60;
             trip.setTotalMinutes((int)diffMinutes);
             return this.tripRepository.save(trip);
        }
        else
            return null;



    }

    public Car findCarByTripId(int tripId){
        Trip trip = this.tripRepository.findOne(tripId);
        return trip.getCar();

    }
    public Driver findDriverByTripId(int tripId){
        Trip trip = this.tripRepository.findOne(tripId);
        return trip.getDriver();

    }
    public Passenger findPassengerByTripId(int tripId){
        Trip trip = this.tripRepository.findOne(tripId);
        return trip.getPassenger();

    }




}
