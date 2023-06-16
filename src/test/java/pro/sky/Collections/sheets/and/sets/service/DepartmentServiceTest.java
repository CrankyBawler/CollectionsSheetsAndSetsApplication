package pro.sky.Collections.sheets.and.sets.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Collections.sheets.and.sets.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;


    @Test
    void sum() {
        Employee employee = new Employee("Иван", "Иванов", 1, 10000);
        Employee employee1 = new Employee("Андрей", "Андреев", 1, 15000);
        Employee employee2 = new Employee("Ирина", "Яковлева", 2, 75135);
        Employee employee3 = new Employee("Евгения", "Сидорова", 3, 55845);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Mockito.when(employeeService.findAll()).thenReturn(employees);

        int actual = departmentService.sum(1);

        assertEquals(25000, actual);
    }


    @Test
    void max() {
        Employee employee = new Employee("Иван", "Иванов", 1, 10000);
        Employee employee1 = new Employee("Андрей", "Андреев", 1, 15000);
        Employee employee2 = new Employee("Ирина", "Яковлева", 2, 75135);
        Employee employee3 = new Employee("Евгения", "Сидорова", 3, 55845);
        List<Employee> employeeMaps = new ArrayList<>();
        employeeMaps.add(employee);
        employeeMaps.add(employee1);
        employeeMaps.add(employee2);
        employeeMaps.add(employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employeeMaps);

        int actual = departmentService.max(1).getSalary();
        assertEquals(15000, actual);

    }


    @Test
    void min() {
        Employee employee = new Employee("Иван", "Иванов", 1, 10000);
        Employee employee1 = new Employee("Андрей", "Андреев", 1, 15000);
        Employee employee2 = new Employee("Ирина", "Яковлева", 2, 75135);
        Employee employee3 = new Employee("Евгения", "Сидорова", 3, 55845);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);

        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        int actual = departmentService.min(1).getSalary();
        assertEquals(10000, actual);

    }


    @Test
    void allByDept() {
        Employee employee = new Employee("Иван", "Иванов", 1, 10000);
        Employee employee1 = new Employee("Андрей", "Андреев", 1, 15000);
        Employee employee2 = new Employee("Ирина", "Яковлева", 2, 75135);
        Employee employee3 = new Employee("Евгения", "Сидорова", 3, 55845);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);
        List<Employee> expected = new ArrayList<>();
        expected.add(employee);
        expected.add(employee1);
        List<Employee> actual = (List<Employee>) departmentService.allByDept(1);

        assertEquals(expected, actual);

    }


    @Test
    void all() {
        Employee employee = new Employee("Иван", "Иванов", 1, 10000);
        Employee employee1 = new Employee("Андрей", "Андреев", 1, 15000);
        Employee employee2 = new Employee("Ирина", "Яковлева", 2, 75135);
        Employee employee3 = new Employee("Евгения", "Сидорова", 3, 55845);
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        Mockito.when(employeeService.getEmployees()).thenReturn(employees);

        Map<Integer, List<Employee>> expected = new HashMap<>();
        List<Employee> list = new ArrayList<>();
        List<Employee> list1 = new ArrayList<>();
        List<Employee> list2 = new ArrayList<>();
        list.add(employee);
        list.add(employee1);
        list1.add(employee2);
        list2.add(employee3);
        expected.put(1, list);
        expected.put(2, list1);
        expected.put(3, list2);

        Map<Integer, List<Employee>> actual = departmentService.all();

        assertEquals(expected, actual);


    }

}