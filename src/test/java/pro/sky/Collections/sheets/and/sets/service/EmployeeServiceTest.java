package pro.sky.Collections.sheets.and.sets.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.Collections.sheets.and.sets.Employee;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private EmployeeService employeeService;


    @BeforeEach
    public void beforeEach() {
        this.employeeService = new EmployeeService();
         }


    @Test
    public void add() {
        Employee expected = new Employee("Иван", "Иванов", 1, 10000);
        Employee actual = null;
        try {
            actual = employeeService.add("Иван", "Иванов", 1, 10000);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }

        assertEquals(expected, actual);
    }


    @Test
    void remove() {
        Employee expected = null;
        try {
            expected = employeeService.add("Иван", "Иванов", 1, 10000);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }

        Employee actual = employeeService.remove("Иван", "Иванов");

            assertEquals(expected, actual);
        }

    @Test
    void find() {
        Employee expected = null;
        try {
            expected = employeeService.add("Иван", "Иванов", 1, 10000);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }

        Employee actual = employeeService.find("Иван", "Иванов");

            assertEquals(expected, actual);

        }

    @Test
    void findAll() {
        Employee emp1 = null;
        try {
            emp1 = employeeService.add("Иван", "Иванов", 1, 10000);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }
        Employee emp2 = null;
        try {
            emp2 = employeeService.add("Андрей", "Андреев", 1, 15000);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }
        Employee emp3 = null;
        try {
            emp3 = employeeService.add("Ирина", "Яковлева", 2, 75135);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }
        Employee emp4 = null;
        try {
            emp4 = employeeService.add("Евгения", "Сидорова", 3, 55845);
        } catch (EmployeeStorageIsFullException e) {
            throw new RuntimeException(e);
        } catch (EmployeeAlreadyAddedException e) {
            throw new RuntimeException(e);
        }

        Collection<Employee> expected = new ArrayList<>();

            expected.add(emp1);
            expected.add(emp2);
            expected.add(emp3);
            expected.add(emp4);


            Collection<Employee> actual = employeeService.getEmployees();

            assertIterableEquals(expected, actual);

        }
    }
