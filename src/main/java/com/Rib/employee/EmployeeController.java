package com.Rib.employee;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "*")
public class EmployeeController 
{

    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee) 
    {
        employeeMap.put(employee.getId(), employee);
        return "Employee added";
    }

    @GetMapping("/all")
    public Collection<Employee> getAllEmployees() 
    {
        return employeeMap.values();
    }

    @PutMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) 
    {
        if (employeeMap.containsKey(id)) 
        {
            employeeMap.put(id, employee);
            return "Employee updated";
        } 
        else 
            return "Employee not found";
        
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) 
    {
        if (employeeMap.containsKey(id)) 
        {
            employeeMap.remove(id);
            return "Employee deleted";
        } else 
            return "Employee not found";
        
    }
}
