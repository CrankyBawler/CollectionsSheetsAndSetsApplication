package pro.sky.Collections.sheets.and.sets;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(" /employee")
public class EmployeeController {
    private final EmployeeInterface employeeService;

    public EmployeeController(EmployeeInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(
            @RequestParam String name,
            @RequestParam String familia) {
        Employee employee = new Employee(name, familia);
        employeeService.addEmployee(employee);
        return "Сотрудник " + name + " " + familia + " добавлен!";
    }
}












