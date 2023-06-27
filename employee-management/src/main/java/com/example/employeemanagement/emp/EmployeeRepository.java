package com.example.employeemanagement.emp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("select emp from Employee emp where emp.employeeEmail=?1")
    Optional<Employee> findEmployeeEmail(String employeeEmail);
}
