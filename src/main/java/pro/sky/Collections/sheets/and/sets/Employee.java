package pro.sky.Collections.sheets.and.sets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private int salary;
    private int department;

    public Employee(String firstName, String lastName, int salary, int department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSalary() {
        return salary;
    }

    public int getDepartment() {
        return department;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && department == employee.department && firstName.equals(employee.firstName) && lastName.equals(employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, salary, department);
    }

        @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

  public List <Employee> maxSalaryDepartment() {
      List<Employee> result = new ArrayList<>();
      for (Employee employe : employes.values()) {

      }
      }
           ) {
          
      }
  }
    //    int a = 0;
    //    String b = null;
    //    for (Employee employee : employe.values) {
    //        if (department == arr[i].getDepartment()) {
    //            if (arr[i].getSalary() >= a) {
    //                a = arr[i].getSalary();
    //                b = arr[i].getFio();
    //            }
    //        }
    //    }
    //    System.out.println("Максимальная заработная плата  в отделе " + department + " составляет " + a + " рублей, у сторудника " + b);
    //    return a;
  //}
  // public static int minSalaryDepartment(Employee[] arr, int department) {
  //     int a = 200_000;
    //     String b = null;
    //     for (int i = 0; i < arr.length; i++) {
    //        if (department == arr[i].getDepartment()) {
    //            if (arr[i].getSalary() <= a) {
    //                a = arr[i].getSalary();
    //                b = arr[i].getFio();
    //            }
    //        }
    //    }
    //    System.out.println("Минимальная заработная плата  в отделе " + department + " составляет " + a + " рублей, у сторудника " + b);
    //    return a;
  //}
    //public static Employee[] toPrintEmployeetoDepartment(Employee[] arr, int department) {
    //   for (int i = 0; i < arr.length; i++) {
    //       if (department == arr[i].getDepartment()) {
    //           System.out.println(arr[i].getId() + ". " + arr[i].getFio() + ". Заработная плата: " + arr[i].getSalary());
    //       }
    //   }
    //   return arr;
  //}
    // public static Employee[] toPrintFio(Employee[] a) {
    //   for (int i = 0; i < a.length; i++) {
    //       System.out.println(a[i].getFio());
    //   }
    //   return a;
    //}
//}