package com.allstate.repositories;

import com.allstate.entities.Passenger;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by localadmin on 31/01/17.
 */
public interface IPassengerRepository extends CrudRepository<Passenger, Integer> {
    public List<Passenger> findByName(String name);

}
