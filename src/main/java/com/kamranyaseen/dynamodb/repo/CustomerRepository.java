package com.kamranyaseen.dynamodb.repo;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.kamranyaseen.dynamodb.model.Customer;

@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {

	List<Customer> findByLastName(String lastName);
}
