package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.*;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IAccountRepository;
import com.example.fabrikaline_backend.Repositories.ICreditStatusRepository;
import com.example.fabrikaline_backend.Repositories.IPurposeRepository;
import com.example.fabrikaline_backend.Repositories.ISpendingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
@AllArgsConstructor
public class SpendingServiceImp implements ISpendingService, IAbstractService<Spending> {

    @Autowired
    ISpendingRepository iSpendingRepository;

    @Autowired
    IPurposeRepository iPurposeRepository;
    @Autowired
    ICreditStatusRepository iCreditStatusRepository;
    @Autowired
    IAccountRepository iAccountRepository;
    @Override
    public Spending save(Spending entity) throws Exception {
        return iSpendingRepository.save(entity);
    }
    @Override
    public Spending save(Spending entity, Long param1) throws Exception {
        return null;
    }

    @Override
    public Spending save(Spending entity, Long param1, Long param2) throws Exception {
        return null;
    }

    @Override
    public Spending save(Spending entity, Long param1, Long param2, Long param3) throws Exception {
        //spending,purposeId,statusId,accountId
        Purpose purpose = iPurposeRepository.findById(param1) .orElseThrow(() -> new IllegalArgumentException("Invalid purpose Id"));
        CreditStatus creditStatus = iCreditStatusRepository.findById(param2) .orElseThrow(() -> new IllegalArgumentException("Invalid creditStatus Id"));
        Account account = iAccountRepository.findById(param3) .orElseThrow(() -> new IllegalArgumentException("Invalid account Id"));

        entity.setPurpose(purpose);
        entity.setCreditStatus(creditStatus);
        entity.setAccount(account);

        if (entity.getActionDate() == null)
        {
            entity.setActionDate(new Date());
        }

        if (entity.getCode() == null)
        {
            // Generate a random number
            Random random = new Random();
            long randomNumber = random.nextLong(1000);
            entity.setCode(String.valueOf(randomNumber));
        }
        iSpendingRepository.save(entity);
        return null;
    }

    @Override
    public List<Spending> getSpendingsByAccount(Long accountId) throws Exception {
        List<Spending> spendingList = iSpendingRepository.getSpendingsByAccount_Id(accountId);
        for( Spending spending : spendingList){
            spending.getAccount().setCreditsGiven(null);
            spending.getAccount().setCreditsReceived(null);
            spending.getAccount().setRepaymentsMade(null);
            spending.getAccount().setRepaymentsReceived(null);
        }

        return  spendingList;
    }


    @Override
    public List<Spending> saveAll(List<Spending> entities) throws Exception {
        return iSpendingRepository.saveAll(entities);
    }

    @Override
    public Spending getById(Long id) {
        Spending spending = iSpendingRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        spending.getAccount().setCreditsGiven(null);
        spending.getAccount().setCreditsReceived(null);
        spending.getAccount().setRepaymentsMade(null);
        spending.getAccount().setRepaymentsReceived(null);

        return  spending;
    }

    @Override
    public List<Spending> getAll() {
        List<Spending> spendingList = iSpendingRepository.findAll();
        for( Spending spending : spendingList){
            spending.getAccount().setCreditsGiven(null);
            spending.getAccount().setCreditsReceived(null);
            spending.getAccount().setRepaymentsMade(null);
            spending.getAccount().setRepaymentsReceived(null);
        }

        return  spendingList;
    }

    @Override
    public void delete(Long id) {
        iSpendingRepository.deleteById(id);
    }

    @Override
    public List<Spending> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(Spending entity) throws ValidationException {

    }

    @Override
    public List<Spending> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception {
        return null;
    }
}
