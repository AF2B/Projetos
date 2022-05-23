package com.af2b.backend.Repository;

import com.af2b.backend.domain.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
    
}
