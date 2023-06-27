package com.example.employeemanagement.emp;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table

public class Employee {
    @Id
    @SequenceGenerator(
            sequenceName = "employee_sequence",
            allocationSize = 1,
            name = "employee_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long employeeId;
    private String employeeName;
    @Transient
    private Integer employeeAge;
    private LocalDate employeeDOB;
    private String employeeEmail;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeName, LocalDate employeeDOB, String employeeEmail) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeDOB = employeeDOB;
        this.employeeEmail = employeeEmail;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getEmployeeAge() {
        return Period.between(employeeDOB,LocalDate.now()).getYears();
    }

    public void setEmployeeAge(Integer employeeAge) {
        this.employeeAge = employeeAge;
    }

    public LocalDate getEmployeeDOB() {
        return employeeDOB;
    }

    public void setEmployeeDOB(LocalDate employeeDOB) {
        this.employeeDOB = employeeDOB;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeAge=" + employeeAge +
                ", employeeDOB=" + employeeDOB +
                ", employeeEmail='" + employeeEmail + '\'' +
                '}';
    }
}
