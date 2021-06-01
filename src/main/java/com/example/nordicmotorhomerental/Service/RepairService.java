package com.example.nordicmotorhomerental.Service;

import com.example.nordicmotorhomerental.Model.MotorHome;
import com.example.nordicmotorhomerental.Model.Repair;
import com.example.nordicmotorhomerental.Repository.MotorHomeRepo;
import com.example.nordicmotorhomerental.Repository.RepairRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    @Autowired
    RepairRepo repairRepo;

    public List<Repair> showRepairList() {
        return repairRepo.showRepairList();
    }

    public Repair createRepair(int id, Repair repair) {
        return repairRepo.createRepair(id, repair);
    }

    public Boolean deleteRepair(int id) {
        return repairRepo.deleteRepair(id);
    }

    public Repair findRepairById(int id) { return repairRepo.findRepairById(id); }

    public Repair editRepair(int id, Repair repair){ return repairRepo.editRepair(id, repair); }

    public Repair addRepairToMotorHome(int motorHomeID){
        return repairRepo.addRepairToMotorHome(motorHomeID);
    }

}
