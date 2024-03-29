package com.howtodoinjava.demo.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.howtodoinjava.demo.exception.RecordNotFoundException;
import com.howtodoinjava.demo.model.EmployeeEntity;
import com.howtodoinjava.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<EmployeeEntity> getAllEmployees() {
		List<EmployeeEntity> employeeList = repository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<EmployeeEntity>();
		}
	}
	
	public Page<EmployeeEntity> findPaginated(Pageable pageable) {
        Page<EmployeeEntity> page = repository.findAll(pageable);
        return page;
	}
	
	public Page<EmployeeEntity> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
	    Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	    Sort.by(sortField).descending();
	 
	    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	    return repository.findAll(pageable);
	}
	
	public EmployeeEntity getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	/*
	 * public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws
	 * RecordNotFoundException { Optional<EmployeeEntity> employee =
	 * repository.findById(entity.getId());
	 * 
	 * if(employee.isPresent()) { EmployeeEntity newEntity = employee.get();
	 * newEntity.setEmail(entity.getEmail());
	 * newEntity.setFirstName(entity.getFirstName());
	 * newEntity.setLastName(entity.getLastName());
	 * 
	 * newEntity = repository.save(newEntity);
	 * 
	 * return newEntity; } else { entity = repository.save(entity);
	 * 
	 * return entity; } }
	 */
	public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(entity.getId());

		if (employee.isPresent()) {
			EmployeeEntity newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			//entity.setId(0L);
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<EmployeeEntity> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}