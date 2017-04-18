package com.ms2003.timesheet.business.service;

import com.ms2003.timesheet.business.dto.EmployeeDTO;
import com.ms2003.timesheet.business.exception.EmployeeNotFoundException;
import com.ms2003.timesheet.business.exception.RoleNotFoundException;
import com.ms2003.timesheet.data.entity.Employee;
import com.ms2003.timesheet.data.entity.Role;
import com.ms2003.timesheet.data.repository.EmployeeRepository;
import com.ms2003.timesheet.data.repository.RoleRepository;
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
    private RoleRepository roleRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository) {
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    public List<EmployeeDTO> getEmployeeInformation(){
        List<EmployeeDTO> list = new ArrayList();
        this.employeeRepository.findAll().forEach(employee->{
            EmployeeDTO e = new EmployeeDTO();
            e.setFirstName(employee.getFirstName());
            e.setLastName(employee.getLastName());
            e.setGender(employee.getGender());
            e.setEmail(employee.getEmail());
            e.setRole(employee.getRole().getRoleName());
            list.add(e);
        });
        return list;
    }

    public void addEmployee(EmployeeDTO newEmployee) {
        Role role = roleRepository.findByRoleName(newEmployee.getRole());
        if(role == null){
            throw new RoleNotFoundException("Role does not exist: "+newEmployee.getRole());
        }
        Employee e = new Employee();
        e.setFirstName(newEmployee.getFirstName());
        e.setLastName(newEmployee.getLastName());
        e.setGender(newEmployee.getGender());
        e.setEmail(newEmployee.getEmail());
        e.setRole(role);
        this.employeeRepository.save(e);
    }

    public void delEmployee(EmployeeDTO employeeDTO) {
        Employee e = this.employeeRepository.findByEmail(employeeDTO.getEmail());
        if(e == null){
            throw new EmployeeNotFoundException("Employee does not exist: "+employeeDTO.getEmail());
        }
        this.employeeRepository.delete(e);
    }

    public void editEmployee(EmployeeDTO employeeDTO) {
        Employee e = this.employeeRepository.findByEmail(employeeDTO.getEmail());
        if(e == null){
            throw new EmployeeNotFoundException("Employee does not exist: "+employeeDTO.getEmail());
        }
        Role role = roleRepository.findByRoleName(employeeDTO.getRole());
        if(role == null){
            throw new RoleNotFoundException("Role does not exist: "+employeeDTO.getRole());
        }
        e.setRole(role);
        e.setGender(employeeDTO.getGender());
        e.setFirstName(employeeDTO.getFirstName());
        e.setLastName(employeeDTO.getLastName());
        this.employeeRepository.save(e);
    }
}
