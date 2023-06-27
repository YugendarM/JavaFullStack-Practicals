import React from "react";
import "../EmployeeDeletionComponent/EmployeeDeletion.css";
import { useState } from "react";

const EmployeeDeletion= () =>{

    const [employeeId,setEmployeeId] = useState("");

    const handleChange = (event) => {
        setEmployeeId(event.target.value);

    }

    const deleteEmployee = async (event) => {
        event.preventDefault();
        await fetch(`http://localhost:8080/employee/v1/api/${employeeId}`,{
            method:"DELETE"
        })
        .then((response) => {
            if(response.status === 500){
                alert("Error!");
            }
            else{
                alert("Employee deleted successfully");
                window.location.href="/";
            }
        })
    }

    return(
        <div className="container">
            <form className="form__container" onSubmit={deleteEmployee}>
                <label className="label">
                    Employee ID:
                    <input className="input" type="number" value={employeeId} onChange={handleChange} name="employeeId" required/>
                </label>
                <button className="submit" type="submit">Submit</button>
            </form>
        </div>
    );
};

export default EmployeeDeletion;