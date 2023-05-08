package pro.sky.Collections.sheets.and.sets.service;

import org.springframework.stereotype.Service;
import pro.sky.Collections.sheets.and.sets.Employee;
import pro.sky.Collections.sheets.and.sets.exception.EmployeeAlredyAddedException;
import pro.sky.Collections.sheets.and.sets.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees;

    public EmployeeServiceImpl() {
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
                        56_153, 3 ),
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

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlredyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    @Override
    public List <Employee> maxSalaryDepartment(Integer department) {
        List<Employee> result = new ArrayList<>();
        int a = 0;
        for (Employee employe : employees.values()) {
            if (employe.maxSalaryDepartment().contains(department)) {
                if (employe.getSalary() >= a) {
                    a = employe.getSalary();


                    //        }
                    //    }
                    //    System.out.println("Максимальная заработная плата  в отделе " + department + " составляет " + a + " рублей, у сторудника " + b);
                    //    return a;
            }
        }

        }

}
