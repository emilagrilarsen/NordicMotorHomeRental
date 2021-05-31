package com.example.nordicmotorhomerental.Repository;

import com.example.nordicmotorhomerental.Model.MotorHome;
import com.example.nordicmotorhomerental.Model.Repair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepairRepo {

    @Autowired
    JdbcTemplate template;

    //Fetch all, som selecter alt fra motorhome tabellen fra databasen og printer dem ud
    public List<Repair> showRepairList(){
        String sql = "SELECT * FROM repair";
        RowMapper<Repair> rowMapper = new BeanPropertyRowMapper<>(Repair.class);
        return template.query(sql, rowMapper);
    }

    public Repair createRepair(Repair repair) {
        String sql = "INSERT INTO repair(note, fuelLevelLow, extraKM, repairPrice) values(?, ?, ?, ?)";

        template.update(sql, repair.getNote(), repair.getFuelLevelLow(), repair.getExtraKM(), repair.getRepairPrice());
        return null;
    }

    public Boolean deleteRepair(int id) {
        String sql = "DELETE FROM repair WHERE repairID = ?";
        return template.update(sql, id) > 0;
    }

    public Repair findRepairById(int id) {
        String sql = "SELECT * FROM repair WHERE repairID = ?";
        RowMapper<Repair> rowMapper = new BeanPropertyRowMapper<>(Repair.class);
        Repair repair = template.queryForObject(sql, rowMapper, id);
        return repair;
    }

    public Repair editRepair(int id, Repair repair){
        String sql = "UPDATE repair SET note = ?, fuelLevelLow = ?, extraKM = ?, repairPrice = ? WHERE repairID = ?";

        template.update(sql, repair.getNote(), repair.getFuelLevelLow(), repair.getExtraKM(), repair.getRepairPrice(), repair.getRepairID());
        return null;
    }

    public MotorHome addRepairToMotorHome(int motorHomeID){
        String sql = "UPDATE motorhome SET motorhome.repairID = (SELECT repair.repairID FROM repair WHERE repairID = " +
                "(SELECT MAX(repairID) FROM repair)) WHERE motorHomeID = ?";

        template.update(sql,  motorHomeID);
        return null;
    }


}