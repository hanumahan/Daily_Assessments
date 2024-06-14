package com.example;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class MainApp{

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder(AppConfig.class)
            .web(WebApplicationType.SERVLET)
            .run(args);

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        // Create and save employees
        Employee emp1 = new Employee("Arya", "IT", 60000);
        Employee emp2 = new Employee("charan", "HR", 50000);
        Employee emp3 = new Employee("Chandhu", "IT", 70000);
        Employee emp4 = new Employee("philip", "Finance", 75000);

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        employeeRepository.save(emp4);

        // Find employees by department
        List<Employee> itEmployees = employeeRepository.findByDepartment("IT");
        System.out.println("Employees in IT department:");
        itEmployees.forEach(emp -> System.out.println(emp.getName()));

        // Find employees with salary greater than 60000
        List<Employee> highSalaryEmployees = employeeRepository.findEmployeesWithSalaryGreaterThan(60000);
        System.out.println("Employees with salary greater than 60000:");
        highSalaryEmployees.forEach(emp -> System.out.println(emp.getName()));
    }
}
