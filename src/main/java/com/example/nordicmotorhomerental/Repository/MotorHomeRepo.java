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
public class MotorHomeRepo {
    @Autowired
    JdbcTemplate template;

    //Fetch all, som selecter alt fra motorhome tabellen fra databasen og printer dem ud
    public List<MotorHome> showMotorHomeList(){
        String sql = "SELECT * FROM motorhome";
        RowMapper<MotorHome> rowMapper = new BeanPropertyRowMapper<>(MotorHome.class);
        return template.query(sql, rowMapper);
    }

    public MotorHome createMotorHome(MotorHome motorHome) {
        String sql = "INSERT INTO motorhome(brand, model, drivenKM, bedCount, pricePerDay) values(?, ?, ?, ?, ?)";
        template.update(sql, motorHome.getBrand(), motorHome.getModel(), motorHome.getDrivenKM(),
                            motorHome.getBedCount(), motorHome.getPricePerDay());
        return null;
    }

    public Boolean deleteMotorHome(int id) {
        String sql = "DELETE FROM motorhome WHERE motorHomeID = ?";
        return template.update(sql, id) > 0;
    }

    public MotorHome findMotorHomeById(int id) {
        String sql = "SELECT * FROM motorhome WHERE motorHomeID = ?";
        RowMapper<MotorHome> rowMapper = new BeanPropertyRowMapper<>(MotorHome.class);
        MotorHome motorHome = template.queryForObject(sql, rowMapper, id);
        return motorHome;
    }

    public MotorHome editMotorHome(int id, MotorHome motorHome){
        String sql = "UPDATE motorhome SET brand = ?, model = ?, drivenKM = ?, bedCount = ?, pricePerDay = ? Where motorHomeID = ?";
        template.update(sql, motorHome.getBrand(), motorHome.getModel(), motorHome.getDrivenKM(),
                            motorHome.getBedCount(), motorHome.getPricePerDay(), motorHome.getMotorHomeID());
        return null;
    }

}
