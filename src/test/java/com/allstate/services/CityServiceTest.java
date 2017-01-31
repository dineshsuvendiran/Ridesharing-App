package com.allstate.services;

import com.allstate.entities.City;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CityServiceTest {
     @Autowired
     CityService cityService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void create_shouldCreateCity() throws Exception {
       City city = new City("Calicut","Kerala",15,20);
        City result = this.cityService.create(city);
        assertEquals(3,result.getId());
    }

    @Test
    public void find_shouldFindCityByName() throws Exception {
        City result = this.cityService.findByName("Chennai");
        assertEquals(2,result.getId());
    }
    @Test
    public void delete_shoulddeleteCityById() throws Exception {
        this.cityService.delete(1);
        City city = this.cityService.findById(1);
        assertNull(city);

    }

}