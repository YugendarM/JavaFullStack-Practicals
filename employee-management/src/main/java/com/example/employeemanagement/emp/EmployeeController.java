package com.example.employeemanagement.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "employee/v1/api")
public class EmployeeController {

    @Autowired
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> fetchEmployees()
    {
        return employeeService.displayEmployees();
    }

    @PostMapping(path = {"/"})
    public void  postEmployees(@RequestBody Employee employee){
        employeeService.registerEmployees(employee);
    }

    @DeleteMapping(path = {"/{id}"})
    public void deleteEmployees(@PathVariable("id") Long employeeId){
        employeeService.removeEmployees(employeeId);
    }

}
