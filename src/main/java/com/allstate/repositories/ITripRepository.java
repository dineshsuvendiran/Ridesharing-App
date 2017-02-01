package com.allstate.repositories;

import com.allstate.entities.Trip;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by localadmin on 01/02/17.
 */
public interface ITripRepository extends CrudRepository<Trip,Integer> {
}
