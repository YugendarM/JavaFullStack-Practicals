import React, { useEffect, useState } from "react";
import "../EmployeeDirectoryComponent/EmployeeDirectory.css";

const EmployeeDirectory = () => {

    const [employees, setEmployees] = useState([]);

    try{
        useEffect(() => {
            fetchEmployees();
        },[]);
    
        const fetchEmployees = async () => {
            const response = await fetch("http://localhost:8080/employee/v1/api/");
            const data = await response.json();
            setEmployees(data);
            console.log(data);
            console.log(employees);
        }
    }
    catch(error){
        console.log("Error!"+error);
    }

    return(
        <div className="container">
            <div className="directory__container">
                {employees.map((employee) => (
                    <div className="employee__card">
                        <p>Employee ID: {employee.employeeId} </p>
                        <p>Employee Name: {employee.employeeName} </p>
                        <p>Employee Age: {employee.employeeAge} </p>
                        <p>Employee DOB: {employee.employeeDOB} </p>
                        <p>Employee Email: {employee.employeeEmail} </p>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default EmployeeDirectory;