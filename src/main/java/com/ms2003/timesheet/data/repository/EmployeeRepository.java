package com.ms2003.timesheet.data.repository;

import com.ms2003.timesheet.data.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by hr on 28/3/17.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
//    void deleteByEmail(@Param("name") String name);
    Employee findByEmail(@Param("name") String name);
}
