package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;

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
	
	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	    Sort.by(sortField).descending();
	 
	    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	    return repository.findAll(pageable);
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
