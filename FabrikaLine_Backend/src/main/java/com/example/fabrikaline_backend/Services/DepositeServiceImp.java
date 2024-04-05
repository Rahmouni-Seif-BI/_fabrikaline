package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.*;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IAccountRepository;
import com.example.fabrikaline_backend.Repositories.ICreditStatusRepository;
import com.example.fabrikaline_backend.Repositories.IPurposeRepository;
import com.example.fabrikaline_backend.Repositories.IDepositeRepository;
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
public class DepositeServiceImp implements IDepositeService, IAbstractService<Deposite> {

    @Autowired
    IDepositeRepository iDepositeRepository;
    @Autowired
    IPurposeRepository iPurposeRepository;
    @Autowired
    ICreditStatusRepository iCreditStatusRepository;
    @Autowired
    IAccountRepository iAccountRepository;


    @Override
    public Deposite save(Deposite entity) throws Exception {
        return iDepositeRepository.save(entity);
    }
    @Override
    public Deposite save(Deposite entity, Long param1) throws Exception {
        //accountId
        Account account = iAccountRepository.findById(param1) .orElseThrow(() -> new IllegalArgumentException("Invalid account Id"));
      //  account.setAmountbalance(account.getAmountbalance() + entity.getAmountToDeposite());
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
        return iDepositeRepository.save(entity);    }

    @Override
    public Deposite save(Deposite entity, Long param1, Long param2) throws Exception {
        return null;
    }

    @Override
    public Deposite save(Deposite entity, Long param1, Long param2, Long param3) throws Exception {
      return null;
    }

    @Override
    public List<Deposite> getDepositesByAccount(Long accountId) throws Exception {
        List<Deposite> depositeList =   iDepositeRepository.getDepositeByAccount_Id(accountId);

        for( Deposite deposite : depositeList){
            deposite.getAccount().setCreditsGiven(null);
            deposite.getAccount().setCreditsReceived(null);
            deposite.getAccount().setRepaymentsMade(null);
            deposite.getAccount().setRepaymentsReceived(null);
        }

        return  depositeList;
    }


    @Override
    public List<Deposite> saveAll(List<Deposite> entities) throws Exception {
        return iDepositeRepository.saveAll(entities);
    }

    @Override
    public Deposite getById(Long id) {
        Deposite spending = iDepositeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        spending.getAccount().setCreditsGiven(null);
        spending.getAccount().setCreditsReceived(null);
        spending.getAccount().setRepaymentsMade(null);
        spending.getAccount().setRepaymentsReceived(null);
        return  spending;
    }

    @Override
    public List<Deposite> getAll() {

        List<Deposite> depositeList =   iDepositeRepository.findAll();

        for( Deposite deposite : depositeList){
            deposite.getAccount().setCreditsGiven(null);
            deposite.getAccount().setCreditsReceived(null);
            deposite.getAccount().setRepaymentsMade(null);
            deposite.getAccount().setRepaymentsReceived(null);
        }
        return  depositeList;
    }

    @Override
    public void delete(Long id) {
//        Account account = iAccountRepository.findByDepositId(id);
//        float depositeToDelete = iDepositeRepository.findById(id).get().getAmountToDeposite();
//        account.setAmountbalance(account.getAmountbalance() - depositeToDelete);
//        iAccountRepository.save(account);
        iDepositeRepository.deleteById(id);
    }

    @Override
    public List<Deposite> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(Deposite entity) throws ValidationException {

    }

    @Override
    public List<Deposite> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception {
        return null;
    }
}
