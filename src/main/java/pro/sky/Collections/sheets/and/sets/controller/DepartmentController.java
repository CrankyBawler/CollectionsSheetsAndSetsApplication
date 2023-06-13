package pro.sky.Collections.sheets.and.sets.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.Collections.sheets.and.sets.Employee;
import pro.sky.Collections.sheets.and.sets.service.DepartmentService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}/employees")
    public Collection<Employee> allByDept(@PathVariable(value = "id") int Id) {
        return service.allByDept(Id);
    }

  //  @GetMapping(value = "/{id}/salary/sum")
  //  public Collection<Employee> sum(@PathVariable(value = "id") int Id) {
  //      return (Collection<Employee>) service.sum(Id);
  //  }

    @GetMapping(value = "/{id}/salary/max")
    public Employee max(@PathVariable (value =  "id") int Id) {
        return service.max(Id);
    }

    @GetMapping(value = "/{id}/salary/min")
    public Employee min(@PathVariable (value = "id") int Id) {

        return service.min(Id);
    }



    @GetMapping("/employees")
    public Map<Integer, List<Employee>> all() {
        return service.all();
    }

}