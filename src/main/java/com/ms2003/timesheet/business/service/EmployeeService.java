package com.ms2003.timesheet.business.service;

import com.ms2003.timesheet.business.domain.EmployeeInfo;
import com.ms2003.timesheet.data.entity.Employee;
import com.ms2003.timesheet.data.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hr on 28/3/17.
 */
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeInfo> getEmployeeInformation(){
        List<EmployeeInfo> list = new ArrayList();
        this.employeeRepository.findAll().forEach(employee->{
            EmployeeInfo e = new EmployeeInfo();
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            list.add(e);
        });
        return list;
    }

    public void addEmployee(EmployeeInfo newEmployee) {
        Employee e = new Employee();
        e.setFirstName(newEmployee.getFirstName());
        e.setLastName(newEmployee.getLastName());
        this.employeeRepository.save(e);
    }
}
