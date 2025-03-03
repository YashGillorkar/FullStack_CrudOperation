package com.yash.crud.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.crud.model.Customer;
import com.yash.crud.repository.CustomerRepository;
import com.yash.crud.service.CustomerServiceI;

@Service
public class CustomerServiceImpl implements CustomerServiceI{

	@Autowired CustomerRepository cr;
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return cr.save(customer); 
	}

	@Override
	public List<Customer> getAllDetails() {
		return cr.findAll();
	}

	@Override
	public void deleteCustomerById(Integer id) {
		cr.deleteById(id);
	}

	@Override
	public Customer getCustomer(Integer id) {
		
		return cr.findById(id).get();
	}

	@Override
	public Customer updateCustomer(Integer id, Customer customer) {
		Optional<Customer> findById = cr.findById(id);
		Customer exitingCustomer = findById.get();
		exitingCustomer.setName(customer.getName());
		exitingCustomer.setEmail(customer.getEmail());
		exitingCustomer.setPhone(customer.getPhone());
		cr.save(exitingCustomer);
		return exitingCustomer;
	}

}
