package com.wm.cache.service;

import com.wm.cache.bean.Employee;
import com.wm.cache.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = "emp",condition = "#id>1")
    public Employee getEmp(Integer id){
        Employee employee = employeeMapper.getEmpById(id);
        return employee;
    }

    @CachePut(value = "emp",key="#result.id")
    public Employee updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
        return employee;
    }

    @CacheEvict(value = "emp",key="#id",allEntries = true)
    public void delteEmp(Integer id){
        System.out.println("delete");
        employeeMapper.deleteById(id);
    }

    @Caching(
            cacheable = {
                    @Cacheable(value = "emp",key="@lastName")
            },
            put = {
                    @CachePut(value = "emp",key = "#result.id"),
                    @CachePut(value = "emp",key = "#result.email")
            }
    )
    public Employee getEmpByName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }
}
