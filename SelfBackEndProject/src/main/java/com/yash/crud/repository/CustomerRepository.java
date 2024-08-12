package com.yash.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yash.crud.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
