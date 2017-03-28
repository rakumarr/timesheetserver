package com.ms2003.timesheet.web.service;

import com.ms2003.timesheet.business.domain.EmployeeInfo;
import com.ms2003.timesheet.business.service.EmployeeService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<EmployeeInfo> getAll(){
        return employeeService.getEmployeeInformation();
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a Employee and save it to the Database")
    public void createEmployee(@ApiBodyObject @RequestBody EmployeeInfo employeeInfo){
        employeeService.addEmployee(employeeInfo);
    }

}
