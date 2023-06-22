package com.gym.controlapp.domain.address.repository;

import com.gym.controlapp.domain.address.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}