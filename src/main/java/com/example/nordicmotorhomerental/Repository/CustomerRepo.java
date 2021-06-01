package com.example.nordicmotorhomerental.Repository;

import com.example.nordicmotorhomerental.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate template;

    //Fetch all, som selecter alt fra customers tabellen fra databasen og printer dem ud
    public List<Customer> showCustomerList(){
        String sql = "SELECT * FROM customer";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public Customer createCustomer(Customer customer) {
        String sql = "INSERT INTO customer(name, address, zipCode, driversLicense) values(?, ?, ?, ?)";
        template.update(sql, customer.getName(), customer.getAddress(),
                customer.getZipCode(), customer.getDriversLicense());
        return null;
    }

    public Boolean deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE customerID = ?";
        return template.update(sql, id) > 0;
    }

    public Customer findCustomerById(int id) {
        String sql = "SELECT * FROM customer WHERE customerID = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        Customer customer = template.queryForObject(sql, rowMapper, id);
        return customer;
    }

    public Customer editCustomer(int id, Customer customer){
        String sql = "UPDATE customer SET name = ?, address = ?, zipCode = ?, driversLicense = ? Where customerID = ?";
        template.update(sql, customer.getName(), customer.getAddress(), customer.getZipCode(), customer.getDriversLicense(), customer.getCustomerID());
        return null;
    }




}
