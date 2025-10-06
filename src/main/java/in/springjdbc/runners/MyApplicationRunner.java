package in.springjdbc.runners;

import in.springjdbc.models.Employee;
import in.springjdbc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private final EmployeeService studentService;

    @Autowired
    public MyApplicationRunner(EmployeeService studentService) {
        this.studentService = studentService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Scanner kb = new Scanner(System.in);
        Employee s;
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }


        }while (choice != 6);

    }
}
