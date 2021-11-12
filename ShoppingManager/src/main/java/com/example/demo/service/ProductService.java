package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Component
public class ProductService {

	@Autowired
	ProductRepository repository;

	public Product createOrUpdateProduct(Product entity) throws RecordNotFoundException {
		// Optional<Product> employee = repository.findById(entity.getId());

		entity = repository.save(entity);

		return entity;
	}

	public List<Product> getAllProduct() {
		List<Product> products = repository.findAll();

		if (products.size() > 0) {
			return products;
		} else {
			return new ArrayList<Product>();
		}
	}
}
