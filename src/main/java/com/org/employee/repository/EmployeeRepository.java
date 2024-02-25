package com.org.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> 
{
	public Optional<Employee> findByName(String name);
	
	public Optional<Employee> findByEmpId(long id);
		
	@Query(value="SELECT * FROM employee_data WHERE "
			+ "name LIKE CONCAT('%',:query,'%')"
			+ "OR designation LIKE CONCAT('%',:query,'%')",nativeQuery = true)
	public List<Employee> searchEmployee(String query); 
}