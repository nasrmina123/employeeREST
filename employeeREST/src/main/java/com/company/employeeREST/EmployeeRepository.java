package com.company.employeeREST;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {


    @Query( "select E from Employee E where " +
            "E.firstName = :firstName")
    List<Employee> searchEmployeeByFirstName(String firstName);


    @Query( "select new com.company.employeeREST.EmployeeDTO (E.id,  E.lastName, E.personalCode)" +
            " from Employee E where E.firstName = :firstName")
    List<EmployeeDTO> searchEmployeeLastName(@Param("firstName") String firstName);


}
