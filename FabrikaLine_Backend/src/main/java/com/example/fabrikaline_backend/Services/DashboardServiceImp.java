package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.Utils.CreditEntityMapper;
import com.example.fabrikaline_backend.ABC.Utils.Global;
import com.example.fabrikaline_backend.ABC.Utils.RepaymentEntityMapper;
import com.example.fabrikaline_backend.DTO.AccountDTO;
import com.example.fabrikaline_backend.DTO.LabelValueObject;
import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.Deposite;
import com.example.fabrikaline_backend.Entities.Spending;
import com.example.fabrikaline_backend.Repositories.IAccountRepository;
import com.example.fabrikaline_backend.Repositories.IDepositeRepository;
import com.example.fabrikaline_backend.Repositories.ISpendingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@AllArgsConstructor
public class DashboardServiceImp  {


    @Autowired
    DepositeServiceImp depositeServiceImp;

    @Autowired
    SpendingServiceImp spendingServiceImp;

    @Autowired
    AccountServiceImp accountServiceImp;

    @Autowired
    private Global global;
   public List<LabelValueObject> getSpendingsByPurpose(){

       List<LabelValueObject> labelValueObjects = new ArrayList<>();

       // Get getSpendingsList
       List<Spending> spendingList = spendingServiceImp.getAll();

       // Create a map to store purpose and their occurrence count
       Map<String, Integer> purposeCountMap = new HashMap<>();

       // Iterate through the spendingList and count occurrences of each purpose
       for(
               Spending spending :spendingList)
       {
           String purposeDescription = spending.getPurpose().getDescription();
           purposeCountMap.put(purposeDescription, purposeCountMap.getOrDefault(purposeDescription, 0) + 1);
       }

       // Create Objects for each distinct purpose and their occurrence count
       for(
               Map.Entry<String, Integer> entry :purposeCountMap.entrySet())
       {
           LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

           labelValueObjects.add(obj);
       }
       return labelValueObjects;
   }

    public List<LabelValueObject> getDepositeByAccount(){

        List<LabelValueObject> labelValueObjects = new ArrayList<>();

        // Get getSpendingsList
        List<AccountDTO> accountDTOS = accountServiceImp.getAllAccounts();

        // Create a map to store purpose and their occurrence count
        Map<String, Integer> accountCountMap = new HashMap<>();

        // Iterate through the spendingList and count occurrences of each purpose
        for(
                AccountDTO accountDTO :accountDTOS)
        {
            String accountDescription = accountDTO.getDescription();
            accountCountMap.put(accountDescription, (int) (accountCountMap.getOrDefault(accountDescription, 0) + accountDTO.getCalculatedAmountBalance()));
        }

        // Create Objects for each distinct  and their occurrence count
        for(
                Map.Entry<String, Integer> entry :accountCountMap.entrySet())
        {
            LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

            labelValueObjects.add(obj);
        }
        return labelValueObjects;
    }

    public List<LabelValueObject> getSpendingsByAccount(){

        List<LabelValueObject> labelValueObjects = new ArrayList<>();

        // Get getSpendingsList
        List<AccountDTO> accountDTOS = accountServiceImp.getAllAccounts();

        // Create a map to store purpose and their occurrence count
        Map<String, Integer> accountCountMap = new HashMap<>();

        // Iterate through the spendingList and count occurrences of each purpose
        for(
                AccountDTO accountDTO :accountDTOS)
        {
            String accountDescription = accountDTO.getDescription();
            accountCountMap.put(accountDescription, (int) (accountCountMap.getOrDefault(accountDescription, 0) + accountDTO.getCalculatedAmountConsumed()));
        }

        // Create Objects for each distinct  and their occurrence count
        for(
                Map.Entry<String, Integer> entry :accountCountMap.entrySet())
        {
            LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

            labelValueObjects.add(obj);
        }
        return labelValueObjects;
    }

    public List<LabelValueObject> getRestAmountByAccount(){

        List<LabelValueObject> labelValueObjects = new ArrayList<>();

        // Get getSpendingsList
        List<AccountDTO> accountDTOS = accountServiceImp.getAllAccounts();

        // Create a map to store purpose and their occurrence count
        Map<String, Integer> accountCountMap = new HashMap<>();

        // Iterate through the spendingList and count occurrences of each purpose
        for(
                AccountDTO accountDTO :accountDTOS)
        {
            String accountDescription = accountDTO.getDescription();
            accountCountMap.put(accountDescription, (int) (accountCountMap.getOrDefault(accountDescription, 0) + accountDTO.getCalculatedAmountRest()));
        }

        // Create Objects for each distinct  and their occurrence count
        for(
                Map.Entry<String, Integer> entry :accountCountMap.entrySet())
        {
            LabelValueObject obj = new LabelValueObject(entry.getKey(),entry.getValue());

            labelValueObjects.add(obj);
        }
        return labelValueObjects;
    }

}
