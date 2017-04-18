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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiMethod(description = "Create a Employee and save it to the Database")
    public void createEmployee(@ApiBodyObject @RequestBody @Validated EmployeeDTO employeeInfo){
        employeeService.addEmployee(employeeInfo);
    }

    @RequestMapping(value="/delete", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiMethod(description = "Delete a Employee from the Database")
    public void deleteEmployee(@RequestBody @Validated EmployeeDTO employeeInfo){
        employeeService.delEmployee(employeeInfo);
    }

    @RequestMapping(value="/edit", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiMethod(description = "Edit a Employee and save it to the Database")
    public void editEmployee(@RequestBody @Validated EmployeeDTO employeeInfo){
        employeeService.editEmployee(employeeInfo);
    }
}
