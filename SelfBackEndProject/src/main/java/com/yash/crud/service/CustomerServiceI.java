package com.yash.crud.service;

import java.util.List;

import com.yash.crud.model.Customer;

public interface CustomerServiceI {

	Customer saveCustomer(Customer customer);

	List<Customer> getAllDetails();

	void deleteCustomerById(Integer id);

	Customer getCustomer(Integer id);

	Customer updateCustomer(Integer id, Customer customer);

}
