package pro.sky.Collections.sheets.and.sets.service;

import org.springframework.stereotype.Service;
import pro.sky.Collections.sheets.and.sets.Employee;
import pro.sky.Collections.sheets.and.sets.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    private Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>((Map.of(
                "Гуляев",
                new Employee("Тихон",
                        "Гуляев",
                        56_272, 4),
                "Шашков",
                new Employee("Савелий",
                        "Шашков",
                        29_104, 1),
                "Николаев",
                new Employee("Остап",
                        "Николаев",
                        56_153, 3),
                "Шаров",
                new Employee("Алексей",
                        "Шаров",
                        42_883, 3),
                "Вишнякова",
                new Employee("Дарина",
                        "Вишнякова",
                        96_463, 1),
                "Калашникова",
                new Employee("Астра",
                        "Калашникова",
                        85_946, 2),
                "Беспалова",
                new Employee("Роксана",
                        "Беспалова",
                        44_277, 2),
                "Лазарева",
                new Employee("Хильда",
                        "Лазарева",
                        69_719, 5),
                "Уварова",
                new Employee("Дана",
                        "Уварова",
                        27_679, 5))));
    }

    public Employee add(String firstName, String lastName, int salary, int department) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        var key = (firstName + "_" + lastName).toLowerCase();
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        var employee = new Employee(firstName, lastName, salary, department);
        var employee1 = new Employee(firstName, lastName, 0, 0);
        employees.put(key, employee);
        return employee;
    }

    public Employee remove(String firstName, String lastName) {
        var key = (firstName + "_" + lastName).toLowerCase();
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return removed;
    }

    public Employee find(String firstName, String lastName) {
        var key = (firstName + "_" + lastName).toLowerCase();
        var employee = employees.get(key);
        if (employee == null) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public Collection<Employee> findAll() {
        return employees.values();
    }
    public Collection<Employee> getEmployees() {
        return employees.values();
    }
}

