package pro.sky.Collections.sheets.and.sets.service;

import pro.sky.Collections.sheets.and.sets.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {
    Employee add(String firstName, String lastName);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    Collection<Employee> findAll();

    List<Employee> maxSalaryDepartment(Integer department);
}
