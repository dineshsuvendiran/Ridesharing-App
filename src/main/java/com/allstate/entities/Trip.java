package com.allstate.entities;

import com.allstate.enums.Gender;
import javax.persistence.*;

import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class Trip {

    private int id;
    private int version;
    private Date startTime;
    private Date endTime;
    private int totalMinutes;
    private Car car;
    private Passenger passenger;
    private City city;
    private double distance;
    private  double cost;
    private double tipPercent;
    private double totalCost;
    private Date created ;
    private Date modified ;


    public Trip() {
    }

    public Trip(Date startTime, Date endTime, Car car, Passenger passenger, City city, double distance, double tipPercent) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.car = car;
        this.passenger = passenger;
        this.city = city;
        this.distance = distance;
        this.tipPercent = tipPercent;
    }
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    @NotNull
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    @NotNull
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    @NotNull
    public int getTotalMinutes() {
        return totalMinutes;
    }

    public void setTotalMinutes(int totalMinutes) {
        this.totalMinutes = totalMinutes;
    }
    @ManyToOne
    @JoinColumn(name="car_id")

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    @ManyToOne
    @JoinColumn(name="passenger_id")

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
    @ManyToOne
    @JoinColumn(name="city_id")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(double tipPercent) {
        this.tipPercent = tipPercent;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
