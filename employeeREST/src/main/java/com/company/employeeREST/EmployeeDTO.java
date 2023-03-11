package com.company.employeeREST;

public class EmployeeDTO {
private int id ;
private String lastName ;
private int personalCode ;

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPersonalCode() {
        return personalCode;
    }

    public EmployeeDTO(int id, String lastName, int personalCode) {
        this.id = id;
        this.lastName = lastName;
        this.personalCode = personalCode;
    }
}
