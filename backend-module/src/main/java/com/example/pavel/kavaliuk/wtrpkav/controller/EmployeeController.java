package com.example.pavel.kavaliuk.wtrpkav.controller;

import com.example.pavel.kavaliuk.wtrpkav.entity.Employee;
import com.example.pavel.kavaliuk.wtrpkav.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public GreetingController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/")
    public String greeting(){
        return "Hello";
    }

    @GetMapping("/employees")
    public String getEmployees(){
        Iterable<Employee> employees = employeeRepository.findAll();
        return employees.toString();
    }

    @PostMapping("/employees")
    public void addEmployee(@RequestBody String name){
        employeeRepository.save(new Employee(name));
    }
}
