package pro.sky.Collections.sheets.and.sets.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.Collections.sheets.and.sets.Employee;
import pro.sky.Collections.sheets.and.sets.exception.EmployeeNotFoundException;
import pro.sky.Collections.sheets.and.sets.exception.InvalidInputException;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeService {
    private static final int MAX_SIZE = 100;
    private Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>((Map.of(
                "Гуляев",
                new Employee("Тихон",
                        "Гуляев",
                        4, 56_272),
                "Шашков",
                new Employee("Савелий",
                        "Шашков",
                        1, 29_104),
                "Николаев",
                new Employee("Остап",
                        "Николаев",
                        3, 56_153),
                "Шаров",
                new Employee("Алексей",
                        "Шаров",
                        3, 42_883),
                "Вишнякова",
                new Employee("Дарина",
                        "Вишнякова",
                        1, 96_463),
                "Калашникова",
                new Employee("Астра",
                        "Калашникова",
                        2, 85_946),
                "Беспалова",
                new Employee("Роксана",
                        "Беспалова",
                        2, 44_277),
                "Лазарева",
                new Employee("Хильда",
                        "Лазарева",
                        5, 69_719),
                "Уварова",
                new Employee("Дана",
                        "Уварова",
                        5, 27_679))));
    }

    public Employee add(String firstName, String lastName, int salary, int department) throws EmployeeStorageIsFullException, EmployeeAlreadyAddedException {
        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        validateInput(firstName, lastName);
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
        validateInput(firstName, lastName);
        var key = (firstName + "_" + lastName).toLowerCase();
        var removed = employees.remove(key);
        if (removed == null) {
            throw new EmployeeNotFoundException();
        }
        return removed;
    }

    public Employee find(String firstName, String lastName) {
        validateInput(firstName, lastName);

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

    private void validateInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && isAlpha(lastName))) {
            throw new InvalidInputException();
        }
    }
}


