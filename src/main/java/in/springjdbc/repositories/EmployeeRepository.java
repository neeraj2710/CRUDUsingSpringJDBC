package in.springjdbc.repositories;


import in.springjdbc.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepository {

    private final NamedParameterJdbcTemplate template;

    @Autowired
    public EmployeeRepository(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    public void save(Employee employee){
        String sql = "INSERT into employees values(:empid,:name,:department,:salary)";
        Map<String, Object> map = new HashMap<>();
        map.put("empid", employee.getEmpid());
        map.put("name", employee.getName());
        map.put("department", employee.getDepartment());
        map.put("salary", employee.getSalary());
        System.out.println("Rec inserted : " + template.update(sql, map));
    }

    public List<Employee> findAll(){
        String sql = "SELECT * FROM employees";
        return template.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public Employee findById(int id){
        String sql = "SELECT * FROM employees WHERE empid = :empid";
        Map<String, Object> map = new HashMap<>();
        map.put("empid", id);
        return template.query(sql,map,new BeanPropertyRowMapper<Employee>(Employee.class)).getFirst();
    }


}
