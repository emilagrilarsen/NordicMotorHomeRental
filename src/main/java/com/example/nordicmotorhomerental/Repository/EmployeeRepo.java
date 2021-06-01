package com.example.nordicmotorhomerental.Repository;

import com.example.nordicmotorhomerental.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepo {

    @Autowired
    JdbcTemplate template;

    //Fetch all, som selecter alt fra customers tabellen fra databasen og printer dem ud
    public List<Employee> showEmployeeList(){
        String sql = "SELECT * FROM employee";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        return template.query(sql, rowMapper);
    }

    public Employee createEmployee(Employee employee) {
        String sql = "INSERT INTO employee(title, name, address, zipCode, CPR) values(?, ?, ?, ?, ?)";
        template.update(sql, employee.getTitle(), employee.getName(), employee.getAddress(), employee.getZipCode(), employee.getCPR());
        return null;
    }

    public Boolean deleteEmployee(int id) {
        String sql = "DELETE FROM employee WHERE employeeID = ?";
        return template.update(sql, id) > 0;
    }

    public Employee findEmployeeById(int id) {
        String sql = "SELECT * FROM employee WHERE employeeID = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = template.queryForObject(sql, rowMapper, id);
        return employee;
    }

    public Employee editEmployee(int id, Employee employee){
        String sql = "UPDATE employee SET title = ?, name = ?, address = ?, zipCode = ?, CPR = ? Where employeeID = ?";
        template.update(sql, employee.getTitle(), employee.getName(), employee.getAddress(), employee.getZipCode(), employee.getCPR(), employee.getEmployeeID());
        return null;
    }
}
