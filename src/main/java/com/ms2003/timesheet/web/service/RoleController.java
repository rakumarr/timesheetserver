package com.ms2003.timesheet.web.service;

import com.ms2003.timesheet.business.dto.RoleDTO;
import com.ms2003.timesheet.business.service.RoleService;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hr on 29/3/17.
 */
@RestController
@RequestMapping(value = "/roles")
@Api(name = "Role API" ,
        description = "Provides a list of methods that manage Role Information",
        stage = ApiStage.BETA)
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    @ApiMethod(description = "Get all Role from Database")
    public List<RoleDTO> getAll(){
        return roleService.getAllRole();
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiMethod(description = "Create a Role and save it to the Database")
    public void createRole(@ApiBodyObject @RequestBody RoleDTO roleDTO){
        roleService.addRole(roleDTO);
    }

}
