package com.ms2003.timesheet.business.service;

import com.ms2003.timesheet.business.dto.RoleDTO;
import com.ms2003.timesheet.data.entity.Role;
import com.ms2003.timesheet.data.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hr on 29/3/17.
 */
@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDTO> getAllRole(){
        List<RoleDTO> roles = new ArrayList<>();
        this.roleRepository.findAll().forEach(role->{
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleName(role.getRoleName());
            roleDTO.setRoleDescription(role.getRoleDescription());
            roles.add(roleDTO);
        });
        return roles;
    }

    public void addRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setRoleName(roleDTO.getRoleName());
        role.setRoleDescription(roleDTO.getRoleDescription());
        this.roleRepository.save(role);
    }
}
