package com.awstesting.app.service;


import com.awstesting.app.Entity.Employee;
import com.awstesting.app.reposistory.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private  final EmployeeRepo employeeRepo;
    public Employee createEmployee(Employee employee) {

        Employee employee1 = employeeRepo.save(employee);
        return employee1;

    }

    public List<Employee> getEmployees() {
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList;
    }

   public  void deleteEmployee(Integer id ,Employee employee) {
        Employee employee1 = employeeRepo.findById(id).orElseThrow(()->new RuntimeException("employee not found"));
        employeeRepo.delete(employee1);
   }
}
