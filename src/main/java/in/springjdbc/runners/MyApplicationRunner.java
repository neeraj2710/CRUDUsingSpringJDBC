package in.springjdbc.runners;

import in.springjdbc.models.Employee;
import in.springjdbc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private final EmployeeService employeeService;

    @Autowired
    public MyApplicationRunner(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Scanner kb = new Scanner(System.in);
        Employee emp;
        int choice;

        do{

            System.out.println("Select an operation");
            System.out.println("1. Register Employee");
            System.out.println("2. View all employees");
            System.out.println("3. Find Employee by ID");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("Enter your choice : ");

            choice = kb.nextInt();

            switch (choice){
                case 1:
                    emp = new Employee();
                    System.out.println("Enter Emp Id");
                    emp.setEmpid(kb.nextInt());
                    System.out.println("Enter Emp Name");
                    emp.setName(kb.next());
                    System.out.println("Enter Department name");
                    emp.setDepartment(kb.next());
                    System.out.println("Enter salary");
                    emp.setSalary(kb.nextDouble());

                    employeeService.addEmployee(emp);
                    break;
                case 2:
                    List<Employee> empList = employeeService.getAllEmployees();
                    if(empList.isEmpty()) System.out.println("No record found");
                    else for (Employee e : empList) System.out.println(e);
                    break;
                case 3:
                    System.out.println("Enter Employee id");
                    emp = employeeService.getEmployeeById(kb.nextInt());
                    if(emp != null)
                        System.out.println(emp);
                    else
                        System.out.println("No record found");
                    break;
                case 4:
                    System.out.println("Enter Emp Id");
                    int id = kb.nextInt();
                    emp = employeeService.getEmployeeById(id);
                    if(emp != null) {
                        System.out.println("Enter salary");
                        double salary = kb.nextDouble();

                        employeeService.updateEmployee(salary, id);
                    }else {
                        System.out.println("No record found for id : "+id);
                    }
                    break;
                case 5:
                    System.out.println("Enter emp Id");
                    int count = employeeService.removeEmployee(kb.nextInt());
                    if(count == 0) System.out.println("no record found");
                    else System.out.println("record deleted successfully");
                    break;
                case 6:
                    System.out.println("Thank You");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }


        }while (choice != 6);

    }
}
