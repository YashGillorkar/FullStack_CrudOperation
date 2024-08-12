package com.yash.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.yash.crud.model.Customer;
import com.yash.crud.service.CustomerServiceI;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {
	
	@Autowired CustomerServiceI csi;
	
	@PostMapping("/saveCustomerDetails")
	public ResponseEntity<Customer> postData(@RequestBody Customer customer){
		Customer obj = csi.saveCustomer(customer);
		return new ResponseEntity<Customer>(obj , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> obj = csi.getAllDetails();
		return new ResponseEntity<List<Customer>>(obj , HttpStatus.OK);
	}

	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteById(@PathVariable Integer id) {
		csi.deleteCustomerById(id);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
		Customer obj = csi.getCustomer(id);
		return new ResponseEntity<Customer>(obj , HttpStatus.OK);
	}
	
	
	@PutMapping("/updateCustomer/{id}")
	public ResponseEntity<Customer> updateById(@PathVariable Integer id , @RequestBody Customer customer){
		Customer obj = csi.updateCustomer(id,customer);
		return new ResponseEntity<Customer>(obj , HttpStatus.OK);
	}
}
