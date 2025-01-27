package com.exceptionhandling.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.exceptionhandling.api.Entity.Employee;
import com.exceptionhandling.api.exceptions.ResourceNotFoundException;
import com.exceptionhandling.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByid(long id) throws ResourceNotFoundException {
		return employeeRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found for this id :: "+ id));
	}
 
	@Override
	public Employee updateEmployee(Employee emp, long id) throws ResourceNotFoundException{
		Employee emp1= employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: "+ id));
		
		emp1 = new Employee(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getDob());
		return employeeRepository.save(emp1);
	}

	@Override
	public void deleteEmployee(long id) throws ResourceNotFoundException{
		Employee emp1= employeeRepository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee not found for this id :: "+ id));
	    employeeRepository.delete(emp1);
	}

}
