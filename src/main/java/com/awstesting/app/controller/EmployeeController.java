package com.awstesting.app.controller;


import com.awstesting.app.Entity.Employee;
import com.awstesting.app.service.EmployeeService;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService  employeeService;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        log.info("Creating Employee : {}", employee);
        return employeeService.createEmployee(employee);

    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = employeeService.getEmployees();
        return employeeList;
    }


    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id, Employee employee) {
        employeeService.deleteEmployee(id,employee);
    }

    @GetMapping("/health")
        public String health() {
        return "app working fine..";
    }

}
