package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = "/sql/seed.sql")
public class PassengerServiceTest {
    @Autowired
    PassengerService passengerService;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_ShouldCreatePassenger() throws Exception {
        Passenger passenger = new Passenger("Sarah",27, Gender.FEMALE,10000);
        Passenger result = passengerService.create(passenger);
        assertEquals(3,result.getId());

    }


    @Test
    public void find_shouldFindPassengerByName() throws Exception {
        List<Passenger> result = this.passengerService.findByName("Nirmal");
        assertEquals(1,result.size());
    }

    @Test
    public void delete_shoulddeletePassengerById() throws Exception {
        this.passengerService.delete(1);
        Passenger passenger = this.passengerService.findById(1);
        assertNull(passenger);
    }



}