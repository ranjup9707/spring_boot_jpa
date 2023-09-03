package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}