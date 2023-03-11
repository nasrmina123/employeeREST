package com.company.employeeREST;

import com.company.employeeREST.POJOS.Employee;
import com.company.employeeREST.POJOS.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Page<Employee> listAllEmployee(Optional<Integer> page , Optional<String> sortBy)
    {
        return employeeRepository.findAll(
                PageRequest.of(page.orElse(0), 3      , Sort.Direction.ASC, sortBy.orElse("id"))
        );
    }

    public void save(Employee employee)
    {
        employeeRepository.save(employee);
    }

    public Employee getEmployee(Integer id)
    {
            return employeeRepository.findById(id).get();
    }

    public ResponseEntity<?> deleteEmployee(Integer id)
    {
        try
        {
            Employee existEmployee =  this.getEmployee(id);
            employeeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (NoSuchElementException e)
        {return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);}
    }


    public ResponseEntity<?> updateEmployee (Employee employee ,Integer id)
    {
        try{
            Employee existEmployee =  this.getEmployee(id);
            existEmployee.setAge(employee.age);
            existEmployee.setFirstName(employee.firstName);
            existEmployee.setLastName(employee.lastName);
            existEmployee.setSalary(employee.salary);
            existEmployee.setPersonalCode(employee.personalCode);

            this.save(employee);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(NoSuchElementException e)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);

        }

    }


      public List<Employee> searchEmloyeeByfirstName(String firstName)
    {
       List<Employee> employees = employeeRepository.searchEmployeeByFirstName(firstName);
       return employees;

    }

    public List<EmployeeDTO> searchEmloyeeLastName(String firstName)
    {
        List<EmployeeDTO> employeesLastName = employeeRepository.searchEmployeeLastName(firstName);
        return employeesLastName;

    }

    public ResponseEntity<Unit> callEmployeeUnit(String uId)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Unit> employeeUnit = restTemplate.getForEntity("http://172.25.143.63:8686/user-service/v1.0/unitOfUser?uId=" + uId , Unit.class);
        return employeeUnit;
    }

}
