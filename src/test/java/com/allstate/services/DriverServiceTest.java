package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
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
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {
   @Autowired
   DriverService driverService;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_ShouldCreateDriver() throws Exception {
        Driver driver = new Driver("Nirmal",22, Gender.MALE);
        Driver result = this.driverService.create(driver);
        assertEquals(3,result.getId());

    }

    @Test
    public void findByName_ShouldFindDriverByName() throws Exception {
       Driver driver = this.driverService.findByName("Nirmal");
        assertEquals(1,driver.getId());

    }
    @Test
    public void delete_shoulddeleteDriverById() throws Exception {
        this.driverService.delete(1);
        Driver driver = this.driverService.findById(1);
        assertNull(driver);

    }

    @Test
    public void addViolationTest() throws Exception {

        Driver victim = this.driverService.findById(2);
        victim.setViolations();
        Driver result =  this.driverService.update(victim);
        assertEquals(1,result.getViolations());
        assertEquals(2,result.getId());
        assertEquals(1,result.getVersion());

    }
    @Test
    public void ckeckBannedOrNotTest() throws Exception {

        Driver victim = this.driverService.findById(2);
        victim.setViolations();
        victim.setViolations();
        victim.setViolations();
        victim.setViolations();

        Driver result =  this.driverService.update(victim);

        assertTrue(result.getBanned());
    }
}