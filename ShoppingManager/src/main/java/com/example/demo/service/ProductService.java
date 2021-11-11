package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;



public class ProductService {

	@Autowired
	ProductRepository repository;
	
	public Product createOrUpdateProduct(Product entity) throws RecordNotFoundException {
		//Optional<Product> employee = repository.findById(entity.getId());

		entity = repository.save(entity);

		return entity;
	}

}
