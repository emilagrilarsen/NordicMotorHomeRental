package com.example.nordicmotorhomerental.Service;

import com.example.nordicmotorhomerental.Model.Employee;
import com.example.nordicmotorhomerental.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public List<Employee> showEmployeeList() {
        return employeeRepo.showEmployeeList();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.createEmployee(employee);
    }

    public Boolean deleteEmployee(int id) {
        return employeeRepo.deleteEmployee(id);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepo.findEmployeeById(id);
    }

    public Employee editEmployee(int id, Employee employee) {
        return employeeRepo.editEmployee(id, employee);
    }

}
