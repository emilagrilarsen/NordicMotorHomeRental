package com.example.nordicmotorhomerental.Service;


import com.example.nordicmotorhomerental.Model.MotorHome;
import com.example.nordicmotorhomerental.Repository.MotorHomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorHomeService {
    @Autowired
    MotorHomeRepo motorHomeRepo;

    public List<MotorHome> showMotorHomeList() {
        return motorHomeRepo.showMotorHomeList();
    }

    public MotorHome createMotorHome(MotorHome motorHome) {
        return motorHomeRepo.createMotorHome(motorHome);
    }

    public Boolean deleteMotorHome(int id) {
        return motorHomeRepo.deleteMotorHome(id);
    }

    public MotorHome findMotorHomeById(int id) {
        return motorHomeRepo.findMotorHomeById(id);
    }

    public MotorHome editMotorHome(int id, MotorHome motorHome) {
        return motorHomeRepo.editMotorHome(id, motorHome);
    }

}
