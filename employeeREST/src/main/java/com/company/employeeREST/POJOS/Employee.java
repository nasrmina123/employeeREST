package com.company.employeeREST.POJOS;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id ;
    @Column(name = "personalCode")
    public int personalCode ;

    @Column(name = "firstName")
    public String firstName ;
    @Column(name = "lastName")
    public String lastName ;
    public int age ;
    public int salary ;


     public Employee() {
    }

    public Employee(int id, int personalCode, String firstName, String lastName, int age, int salary) {
        this.id = id;
        this.personalCode = personalCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(int personalCode) {
        this.personalCode = personalCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
