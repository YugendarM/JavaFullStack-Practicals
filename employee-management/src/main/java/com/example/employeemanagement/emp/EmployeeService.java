package com.example.employeemanagement.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    public final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> displayEmployees() {

        return employeeRepository.findAll();
    }

    public void registerEmployees(Employee employee) {
        Optional<Employee> optionalEmployee =employeeRepository.findEmployeeEmail(employee.getEmployeeEmail());
        if(optionalEmployee.isPresent())
        {
            throw new IllegalStateException("Email already exits");
        }
        employeeRepository.save(employee);
    }


    public void removeEmployees(Long employeeId) {
        boolean employeeExists = employeeRepository.existsById(employeeId);

        if(!employeeExists){
            throw new IllegalStateException("Employee does not exist");
        }

        employeeRepository.deleteById(employeeId);

    }
}
