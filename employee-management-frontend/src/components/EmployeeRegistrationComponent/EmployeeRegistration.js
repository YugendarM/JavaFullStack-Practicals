import React, { useState } from "react";
import "../EmployeeRegistrationComponent/EmployeeRegistration.css";


const EmployeeRegistration = () => {

    const [employees,setEmployees] = useState({
        employeeName:'',
        employeeDOB:'',
        employeeEmail:''
    });

    const handleChange = (event) => {
        const {name,value} = event.target;
        setEmployees({...employees,[name]:value});
    }

    const postEmployees = async (event) => {
        event.preventDefault();
        await fetch("http://localhost:8080/employee/v1/api/",{
            method:"POST",
            headers :{
                'Content-Type':'Application/json'
            },
            body : JSON.stringify(employees)

        })
        .then((response) => {
            if(response.status === 500)
            {
                alert("Error!");
            }
            else {
                alert("Employee Added succcessfully");
                window.location.href="/";
            }
        })
    };

    return(
        <div className="container">
            <form className="form__container" onSubmit={postEmployees}>
                <label className="label">
                    Employee Name:
                    <input className="input" type="text" value={employees.employeeName} onChange={handleChange} name="employeeName" required/>
                </label>

                <label className="label">
                    Employee DOB:
                    <input className="input" type="date" value={employees.employeeDOB} onChange={handleChange} name="employeeDOB" required/>
                </label>

                <label className="label">
                    Employee Email:
                    <input className="input" type="email" value={employees.employeeEmail} onChange={handleChange} name="employeeEmail" required/>
                </label>
                
                <button className="submit" type="submit">Submit</button>

            </form>
        </div>
    );
};

export default EmployeeRegistration;