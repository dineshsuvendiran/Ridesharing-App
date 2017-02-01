package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.enums.CarClass;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})

public class CarServiceTest {
    @Autowired
    CarService carService;
    @Autowired
    DriverService driverService;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_ShouldCreateCarClass() throws Exception {
        Driver driver = new Driver("Nirmal",22, Gender.MALE);
        Driver driveresult = this.driverService.create(driver);
        Car car = new Car("Nissan","Sunny",2012, CarClass.BASIC,driveresult);
        Car result = carService.create(car);
        assertEquals(1,result.getId());

    }

    @Test
    public void findCar_FindBYMake() throws Exception {
        Driver driver = new Driver("Nirmal",22, Gender.MALE);
        Driver driveresult = this.driverService.create(driver);
        Car car = new Car("Nissan","Sunny",2012, CarClass.BASIC,driveresult);
        carService.create(car);
        List<Car> result = carService.findByName("Nissan");
        assertEquals(1,result.size());

    }

    @Test
    public void findDriverForCar() throws Exception {
        Driver driver = this.carService.findDriver(1);
        assertEquals("Nirmal",driver.getName());
    }

    @Test
    @Transactional
    public void find_findAllTripsAssociatedWithCar() throws Exception {

        List<Trip> trip = this.carService.findAllTripsAssociatedWithCar(1);
        assertEquals(2,trip.size());

    }
}