package com.allstate.repositories;


import com.allstate.entities.Driver;
import com.sun.tools.javac.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IDriverRepository extends CrudRepository<Driver,Integer>{
    Driver findByName(String name);

}
