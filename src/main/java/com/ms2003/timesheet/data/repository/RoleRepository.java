package com.ms2003.timesheet.data.repository;

import com.ms2003.timesheet.data.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by hr on 29/3/17.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role,Integer>{

    Role findByRoleName(@Param("name") String name);
}
