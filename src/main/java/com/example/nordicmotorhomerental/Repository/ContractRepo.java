package com.example.nordicmotorhomerental.Repository;

import com.example.nordicmotorhomerental.Model.Contract;

import com.example.nordicmotorhomerental.Model.MotorHome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;



@Repository
public class ContractRepo {

    @Autowired
    JdbcTemplate template;

    public List<Contract> showContractList(){
        String sql = "SELECT * FROM contract";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        return template.query(sql, rowMapper);
    }

    public Contract createContract(int id, Contract contract, MotorHome motorHome) {
        String sql = "INSERT INTO contract(employeeID, customerID, motorHomeID, extraEquipment, pickUpKM, dropOffKM, " +
                "totalPrice, startDate, endDate) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        template.update(sql, contract.getEmployeeID(), contract.getCustomerID(), contract.getMotorHomeID(),
                contract.getExtraEquipment(), contract.getPickUpKM(), contract.getDropOffKM(),
                contract.getTotalPrice(motorHome.getPricePerDay()),
                contract.getStartDate(), contract.getEndDate());
        return null;
    }


    public Boolean deleteContract(int id) {
        String sql = "DELETE FROM contract WHERE contractID = ?";
        return template.update(sql, id) > 0;
    }

    public Contract findContractById(int id) {
        String sql = "SELECT * FROM contract WHERE contractID = ?";
        RowMapper<Contract> rowMapper = new BeanPropertyRowMapper<>(Contract.class);
        Contract contract = template.queryForObject(sql, rowMapper, id);
        return contract;
    }

    public Contract editContract(int id, Contract contract, MotorHome motorHome){
        String sql = "UPDATE contract SET employeeID = ?, customerID = ?, motorHomeID = ?, extraEquipment = ?, " +
                "pickUpKM = ?, dropOffKM = ?, startDate = ?, endDate = ?, totalPrice = ? Where motorHomeID = ?";

        template.update(sql, contract.getEmployeeID(), contract.getCustomerID(), contract.getMotorHomeID(),
                contract.getExtraEquipment(), contract.getPickUpKM(), contract.getDropOffKM(),
                contract.getStartDate(), contract.getEndDate(),  contract.getTotalPrice(motorHome.getPricePerDay()), contract.getMotorHomeID());
        return null;
    }

    public Contract setCancellationPrice(int id, Contract c){
        String sql = "UPDATE contract SET totalPrice = ? WHERE contractID = ?";

        System.out.println(c.cancel(c.getTotalPrice()));

        template.update(sql, c.cancel(c.getTotalPrice()), c.getContractID());
        return null;
    }




}
