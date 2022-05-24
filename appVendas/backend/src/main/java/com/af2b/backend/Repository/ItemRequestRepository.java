package com.af2b.backend.Repository;

import com.af2b.backend.domain.ItemRequest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRequestRepository extends JpaRepository<ItemRequest, Integer>{
    
}
