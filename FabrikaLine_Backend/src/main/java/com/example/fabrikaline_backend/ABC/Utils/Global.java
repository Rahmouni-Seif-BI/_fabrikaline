package com.example.fabrikaline_backend.ABC.Utils;

import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.Deposite;
import com.example.fabrikaline_backend.Repositories.IDepositeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Global {
    @Autowired
    IDepositeRepository iDepositeRepository;

    public void calculateDeposits(Account account) {
        float depositeAmount = 0;
        List<Deposite> deposites = iDepositeRepository.getDepositeByAccount_Id(account.getId());
        for (Deposite deposite : deposites) {
            depositeAmount += deposite.getAmountToDeposite();
        }
        account.setCalculatedAmountbalance(depositeAmount);
    }

    public Integer calculateDepositsStat(Account account) {
        float depositeAmount = 0;
        List<Deposite> deposites = iDepositeRepository.getDepositeByAccount_Id(account.getId());
        for (Deposite deposite : deposites) {
            depositeAmount += deposite.getAmountToDeposite();
        }
        return  (int)depositeAmount;
    }
}
