package com.wm.cache.controller;

import com.wm.cache.bean.Employee;
import com.wm.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        Employee emp = employeeService.getEmp(id);
        return emp;

    }

    @GetMapping("/emp")
    public Employee update(Employee employee){
        Employee emp = employeeService.updateEmp(employee);
        return emp;
    }

    @GetMapping("/delete")
    public String deleteEmp(Integer id){
        employeeService.delteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmployeeByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByName(lastName);
    }
}



