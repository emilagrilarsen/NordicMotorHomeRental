package com.example.nordicmotorhomerental.Service;

import com.example.nordicmotorhomerental.Model.Contract;
import com.example.nordicmotorhomerental.Model.MotorHome;
import com.example.nordicmotorhomerental.Repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    ContractRepo contractRepo;

    public List<Contract> showContractList() {
        return contractRepo.showContractList();
    }

    public Contract createContract(int id, Contract contract, MotorHome motorHome) {
        return contractRepo.createContract(id, contract, motorHome);
    }

    public Boolean deleteContract(int id) {
        return contractRepo.deleteContract(id);
    }

    public Contract findContractById(int id) {
        return contractRepo.findContractById(id);
    }

    public Contract editContract(int id, Contract contract, MotorHome motorHome) {
        return contractRepo.editContract(id, contract, motorHome);
    }

    public Contract setCancellationPrice(int id, Contract c){ return contractRepo.setCancellationPrice(id, c);}
}
