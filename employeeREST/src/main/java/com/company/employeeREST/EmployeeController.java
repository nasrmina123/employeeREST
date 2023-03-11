package com.company.employeeREST;


import com.company.employeeREST.Beans.Employee;
import com.company.employeeREST.Beans.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;



    @GetMapping("/Employees")
    public Page<Employee> listAllEmployee(
            @RequestParam Optional<Integer> page ,
            @RequestParam Optional<String> sortBy
            )
    {

        return employeeService.listAllEmployee(page , sortBy);

    }



    @GetMapping("/Employee/{id}")
    public void getEmployeeById (@PathVariable Integer id)
    {

            Employee employee =  employeeService.getEmployee(id);

    }

    @PostMapping("/Employees")
    public void addEmployee(@RequestBody Employee employee)
    {
        employeeService.save(employee);
    }

    @PutMapping("/Employees/{id}")
    public void updateEmployeeById (@RequestBody Employee employee ,  @PathVariable Integer id)
    {
             employeeService.updateEmployee(employee , id);
    }

    @DeleteMapping("/Employee/{id}")
    public void deleteEmployeeById(@PathVariable Integer id)
    {
            employeeService.deleteEmployee(id);
    }


    @GetMapping("/EmployeesbyName")
    public List<Employee> getEmployeeByfirstName(@RequestParam("firstName") String firstName) {
        List<Employee> employees = employeeService.searchEmloyeeByfirstName(firstName);
        return employees;
    }



    public List<EmployeeDTO> getEmployeeLastName(@RequestParam("firstName") String firstName) {
        List<EmployeeDTO> employeesLastName = employeeService.searchEmloyeeLastName(firstName);
        return employeesLastName;
    }


    @GetMapping("/EmployeeUnit")
   public ResponseEntity<Unit> EmployeeUnit(@RequestParam("uId") String uId)
        {

        ResponseEntity<Unit> employeeUnit = employeeService.callEmployeeUnit(uId);
        return employeeUnit ;

    }




}
