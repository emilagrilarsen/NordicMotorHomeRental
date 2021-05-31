package com.example.nordicmotorhomerental.Service;

import com.example.nordicmotorhomerental.Model.Customer;
import com.example.nordicmotorhomerental.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> showCustomerList() {
        return customerRepo.showCustomerList();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepo.createCustomer(customer);
    }

    public Boolean deleteCustomer(int id) {
        return customerRepo.deleteCustomer(id);
    }

    public Customer findCustomerById(int id) {
        return customerRepo.findCustomerById(id);
    }

    public Customer editCustomer(int id, Customer customer) {
        return customerRepo.editCustomer(id, customer);
    }

}
