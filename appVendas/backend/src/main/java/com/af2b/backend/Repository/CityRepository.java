package com.af2b.backend.Repository;

import com.af2b.backend.domain.City;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
    
}
