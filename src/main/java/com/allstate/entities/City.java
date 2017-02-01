package com.allstate.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table (name = "cities")

public class City {


    private int id;
    private int version;
    private String name;
    private String state;
    private double rateperKmDay;
    private double rateperKmNight;
    private Date created ;
    private Date modified ;
    private List<Trip> trips;
    private List<Driver> drivers;
    private List<Passenger> passengers;

    public City() {
    }

    public City(String name, String state, double rateperKmDay, double rateperKmNight) {
        this.name = name;
        this.state = state;
        this.rateperKmDay = rateperKmDay;
        this.rateperKmNight = rateperKmNight;
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
    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @NotNull
    public double getRateperKmDay() {
        return rateperKmDay;
    }

    public void setRateperKmDay(double rateperKmDay) {
        this.rateperKmDay = rateperKmDay;
    }

    @NotNull
    public double getRateperKmNight() {
        return rateperKmNight;
    }

    public void setRateperKmNight(double rateperKmNight) {
        this.rateperKmNight = rateperKmNight;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @OneToMany(mappedBy = "city")
    @JsonIgnore
    public List<Trip> getTrips() {
        return trips;
    }
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }


    @ManyToMany
    @JoinTable(name = "trips",
            joinColumns = @JoinColumn(name = "driver_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "city_id", referencedColumnName = "id"))
    @JsonIgnore
    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @ManyToMany
    @JoinTable (name = "trips",
        joinColumns = @JoinColumn(name ="city_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name ="passenger_id", referencedColumnName = "id"))
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
