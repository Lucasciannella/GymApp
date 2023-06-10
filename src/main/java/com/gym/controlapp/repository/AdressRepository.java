package com.gym.controlapp.repository;

import com.gym.controlapp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Address, Long> {
}