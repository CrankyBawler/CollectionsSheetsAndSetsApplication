package pro.sky.Collections.sheets.and.sets;

import java.util.List;

public class EmployeeService {
    List<Employee> employees = List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Тихон", "Гуляев"),
            new Employee("Савелий", "Шашков"),
            new Employee("Остап", "Николаев"),
            new Employee("Алексей", "Шаров"),
            new Employee("Дарина", "Вишнякова"),
            new Employee("Астра", "Калашникова"),
            new Employee("Роксана", "Беспалова"),
            new Employee("Хильда", "Лазарева"),
            new Employee("Дана", "Уварова")
    );

    public void addEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                throw new EmployeeAlreadyAddedException();
            } else
                employees.add((Employee) employees);
        }
    }

    public void deleteEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.remove(employee);
            }
            if (!employee.getFirstName().equals(firstName) && !employee.getLastName().equals(lastName)) {
                throw new EmployeeNotFoundException();
            }
        }
    }

    public void findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employees.contains(employee);
            }
            if (!employee.getFirstName().equals(firstName) && !employee.getLastName().equals(lastName)) {
                throw new EmployeeNotFoundException();
            }

        }
    }
}