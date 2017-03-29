package com.ms2003.timesheet.web.service;

import com.ms2003.timesheet.business.dto.EmployeeDTO;
import com.ms2003.timesheet.business.service.EmployeeService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hr on 28/3/17.
 */
@RestController
@RequestMapping(value="/employees")
@Api(name = "Employee API" ,
        description = "Provides a list of methods that manage Employee Information",
        stage = ApiStage.BETA)
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all Employee from Database")
    public List<EmployeeDTO> getAll(){
        return employeeService.getEmployeeInformation();
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiMethod(description = "Create a Employee and save it to the Database")
    public void createEmployee(@ApiBodyObject @RequestBody @Validated EmployeeDTO employeeInfo){
        employeeService.addEmployee(employeeInfo);
    }

}
