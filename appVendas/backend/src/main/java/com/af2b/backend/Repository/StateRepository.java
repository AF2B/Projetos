package com.af2b.backend.Repository;

import com.af2b.backend.domain.State;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
    
}
