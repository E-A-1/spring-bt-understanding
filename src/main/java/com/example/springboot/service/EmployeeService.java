package com.example.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.springboot.entity.Employee;
import com.example.springboot.repo.EmployeeRepo;

@Service
public class EmployeeService implements CommandLineRunner {

    @Autowired
    public EmployeeRepo employeeRepo;

    public void createNewEmployee() {
        try {
            Employee employee = new Employee();
            employee.setEmployeeContact("1231234234");
            employee.setEmployeeName("harryStyles");
            if (employeeRepo == null) {
                System.out.println("Null value present");
            } else {

                employeeRepo.save(employee);

            }
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

    }

    public void listAllEmployees() {

        List<Employee> employeeList = employeeRepo.findAll();

        employeeList.forEach((employee) -> {
            System.out.print(employee.getEmployeeName());
            System.out.println("---------");
            System.out.println(employee.getEmployeeId());
        });
    }

    public void getEmployeeById() {
        Optional<Employee> employee = employeeRepo.findById(1);

        if (employee.isPresent()) {

            System.out.println("Emplyoee found !! aieee " + employee.get().getEmployeeId());
        } else {
            System.out.println("Employee not found");
        }
    }

    public void getEmployeeByName() {
        Optional<Employee> employee = employeeRepo.findByEmployeeName("harryStyles");

        if (employee.isPresent()) {

            System.out.println("Emplyoee found !! heyyyy " + employee.get().getEmployeeId());
        } else {
            System.out.println("Employee not found");
        }
    }

    public void getEmployeeByNameAndEmployeeContact() {
        List<Employee> employee = employeeRepo.findByEmployeeNameAndEmployeeContact("sdfsdfsadf", "");

        if (employee.size() == 0) {

            System.out.println("Emplyoee found !! heyyyy " + employee.get(0).getEmployeeId());
        } else {
            System.out.println("Employee not found when using contact number and emp name");
        }
    }

    public void deleteEmployee() {
        employeeRepo.deleteById(2);
    }

    @Override
    public void run(String... args) throws Exception {
        createNewEmployee();
        listAllEmployees();
        getEmployeeById();
        getEmployeeByName();
        getEmployeeByNameAndEmployeeContact();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}
