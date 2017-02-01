package com.allstate.services;

import com.allstate.entities.*;
import com.allstate.enums.CarClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TripServiceTest {
    @Autowired
    DriverService driverService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    CityService cityService;

    @Autowired
    TripService tripService;

    @Autowired
    CarService carService;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_shouldCreateTrip() throws Exception {
        Driver driver = this.driverService.findById(1);
        Passenger passenger = this.passengerService.findById(1);
        Car car = new Car("Nissan","Sunny",2012, CarClass.BASIC,driver);
        Car carSave = this.carService.create(car);
        City city = this.cityService.findById(1);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        String startDateString = "01-Feb-2017 13:25";
        Date startTime = formatter.parse(startDateString);

        String endDateString = "01-Feb-2017 14:25";
        Date endTime = formatter.parse(endDateString);



        Trip trip = new Trip(startTime,endTime, carSave,passenger,city,driver,50,10);
        Trip result = this.tripService.createTrip(trip);
        assertEquals(4,result.getId());





    }
    @Test
    public void create_shouldNotCreateTripForPassengersHaveLessMoney() throws Exception {
        Driver driver = this.driverService.findById(1);
        driver.setViolations();
        driver.setViolations();
        driver.setViolations();
        driver.setViolations();
        driver = this.driverService.create(driver);
        Passenger passenger = this.passengerService.findById(1);

        Car car = new Car("Nissan","Sunny",2012, CarClass.BASIC,driver);
        Car carSave = this.carService.create(car);
        City city = this.cityService.findById(1);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        String startDateString = "01-Feb-2017 13:25";
        Date startTime = formatter.parse(startDateString);

        String endDateString = "01-Feb-2017 14:25";
        Date endTime = formatter.parse(endDateString);



        Trip trip = new Trip(startTime,endTime, carSave,passenger,city,driver,50,10);
        Trip result = this.tripService.createTrip(trip);
        assertNull(result);




    }

    @Test
    public void create_shouldNotCreateTripForBannedDriver() throws Exception {
        Driver driver = this.driverService.findById(1);
        Passenger passenger = this.passengerService.findById(1);
        passenger.setCreditBalance(10);
        passenger = this.passengerService.create(passenger);
        Car car = new Car("Nissan","Sunny",2012, CarClass.BASIC,driver);
        Car carSave = this.carService.create(car);
        City city = this.cityService.findById(1);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        String startDateString = "01-Feb-2017 13:25";
        Date startTime = formatter.parse(startDateString);

        String endDateString = "01-Feb-2017 14:25";
        Date endTime = formatter.parse(endDateString);



        Trip trip = new Trip(startTime,endTime, carSave,passenger,city,driver,50,10);
        Trip result = this.tripService.createTrip(trip);
        assertNull(result);
    }
    @Test
    public void create_shouldAddExtraCHargeForLUXCarClass() throws Exception {
        Driver driver = this.driverService.findById(1);
        Passenger passenger = this.passengerService.findById(1);

        passenger = this.passengerService.create(passenger);
        Car car = new Car("Nissan","Sunny",2012, CarClass.LUX,driver);
        Car carSave = this.carService.create(car);
        City city = this.cityService.findById(1);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
        String startDateString = "01-Feb-2017 13:25";
        Date startTime = formatter.parse(startDateString);

        String endDateString = "01-Feb-2017 14:25";
        Date endTime = formatter.parse(endDateString);



        Trip trip = new Trip(startTime,endTime, carSave,passenger,city,driver,50,0);
        Trip result = this.tripService.createTrip(trip);

        assertEquals(1050,result.getTotalCost(),0);
    }

    @Test
    @Transactional
    public void findCarForGivenTrip() throws Exception{

        Car car = this.tripService.findCarByTripId(1);
        assertEquals(1,car.getId());

    }
    @Test
    @Transactional
    public void findDriverForGivenTrip() throws Exception{

        Driver driver = this.tripService.findDriverByTripId(2);
        assertEquals(2,driver.getId());

    }

    @Test
    @Transactional
    public void findPassengerForGivenTrip() throws Exception{

        Passenger passenger = this.tripService.findPassengerByTripId(2);
        assertEquals(1,passenger.getId());
    }

}