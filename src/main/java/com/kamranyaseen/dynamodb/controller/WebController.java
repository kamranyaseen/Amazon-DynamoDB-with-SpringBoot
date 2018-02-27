package com.kamranyaseen.dynamodb.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kamranyaseen.dynamodb.model.Customer;
import com.kamranyaseen.dynamodb.repo.CustomerRepository;

@RestController
public class WebController {

	@Autowired
	CustomerRepository repository;

	@RequestMapping("/delete")
	public String delete() {
		repository.deleteAll();
		return "Done";
	}

	@RequestMapping("/save")
	public String save() {
		repository.save(new Customer("CSU-1", "Jack", "Smith"));
		repository.save(Arrays.asList(
				new Customer("CSU-2", "Adam", "Johnson"), 
				new Customer("CSU-3", "Kim", "Smith"),
				new Customer("CSU-4", "David", "Williams"),
				new Customer("CSU-5", "Peter", "Davis")));

		return "Successfully done";
	}

	@RequestMapping("/findall")
	public String findAll() {
		String result = "";
		Iterable<Customer> customers = repository.findAll();

		for (Customer cust : customers) {
			result += cust.toString() + "<br>";
		}

		return result;
	}

	@RequestMapping("/findbyid")
	public String findById(@RequestParam("id") String id) {
		String result = "";
		result = repository.findOne(id).toString();
		return result;
	}

	@RequestMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName) {
		String result = "";

		for (Customer cust : repository.findByLastName(lastName)) {
			result += cust.toString() + "<br>";
		}

		return result;
	}
}
