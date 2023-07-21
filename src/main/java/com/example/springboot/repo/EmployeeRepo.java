package com.example.springboot.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmployeeName(String employeeName);

    List<Employee> findByEmployeeNameAndEmployeeContact(String employeeName, String employeeContact);

}
