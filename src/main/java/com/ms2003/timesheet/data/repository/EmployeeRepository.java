package com.ms2003.timesheet.data.repository;

import com.ms2003.timesheet.data.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by hr on 28/3/17.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
}
