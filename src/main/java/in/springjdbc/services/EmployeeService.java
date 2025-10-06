package in.springjdbc.services;


import in.springjdbc.models.Employee;
import in.springjdbc.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee emp){
        repository.save(emp);
    }

    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        return repository.findById(id);
    }

    public void updateEmployee(double salary, int id){
        repository.update(salary, id);
    }

    public int removeEmployee(int id){
        return repository.delete(id);
    }

}
