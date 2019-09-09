package com.practise.springdemo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practise.springdemo.model.SpringModel;
import com.practise.springdemo.service.SpringService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	private SpringService customerService;

	@PostMapping
	public SpringModel addCustomer(@RequestBody SpringModel customer){
		return customerService.addCustomer(customer);
	}

	@GetMapping
	public List<SpringModel> getCustomers()
	{
		return customerService.getCustomers();
	}

	@GetMapping(value = "/{customerId}")
	public SpringModel getCustomer(@PathVariable("customerId") int customerId)
	{
		return customerService.getCustomer(customerId);
	}

	@PutMapping(value = "/{customerId}")
	public SpringModel updateCustomer(@PathVariable("customerId")int customerId,@RequestBody SpringModel customer)
	{
		return customerService.updateCustomer(customerId, customer);
	}

	@DeleteMapping(value = "/{customerId}")
	public void deleteCustomer(@PathVariable("customerId") int customerId)
	{
		customerService.deleteCustomer(customerId);
	}
}
