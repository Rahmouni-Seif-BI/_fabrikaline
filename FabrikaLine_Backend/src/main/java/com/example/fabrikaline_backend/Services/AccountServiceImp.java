package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.ABC.Utils.CreditEntityMapper;
import com.example.fabrikaline_backend.ABC.Utils.Global;
import com.example.fabrikaline_backend.ABC.Utils.RepaymentEntityMapper;
import com.example.fabrikaline_backend.DTO.AccountDTO;
import com.example.fabrikaline_backend.DTO.CreditEntityDTO;
import com.example.fabrikaline_backend.DTO.RepaymentEntityDTO;
import com.example.fabrikaline_backend.Entities.*;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IAccountRepository;
import com.example.fabrikaline_backend.Repositories.IDepositeRepository;
import com.example.fabrikaline_backend.Repositories.ISpendingRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class AccountServiceImp   implements IAccountService, IAbstractService<Account> {

    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    ISpendingRepository iSpendingRepository;

    @Autowired
    IDepositeRepository iDepositeRepository;

    @Autowired
    private CreditEntityMapper creditEntityMapper;

    @Autowired
    private RepaymentEntityMapper repaymentEntityMapper;

    @Autowired
    private IAccountRepository accountRepository;

    @Autowired
    private Global global;

    public List<AccountDTO> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountDTO> accountDTOS = new ArrayList<AccountDTO>();

        for (Account account: accounts){
            global.calculateDeposits(account);
            calculateSpendings(account);
            calculateRemainingBalance(account);
            AccountDTO accountDTO = new AccountDTO(account.getId(), account.getCode(), account.getDescription(), account.getOwner(), account.getCalculatedAmountbalance(), account.getCalculatedAmountconsumed(), account.getCalculatedAmountRest());
            account.setCreditsGiven(null);
            account.setCreditsReceived(null);
            account.setRepaymentsMade(null);
            account.setRepaymentsReceived(null);
            accountDTOS.add(accountDTO);
        }
        return accountDTOS;
    }


    public List<CreditEntityDTO> getCreditsGivenByAccount(Long accountId) {
        Account creditorAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Creditor account not found"));
        return creditEntityMapper.toDTOList(creditorAccount.getCreditsGiven()); // Use the mapper to map entities to DTOs;
    }


    @Override
    public List<CreditEntityDTO> getCreditsReceivedByAccount(Long accountId) {
        Account debtorAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Debtor account not found"));
                return creditEntityMapper.toDTOList(debtorAccount.getCreditsReceived()); // Use the mapper to map entities to DTOs;
    }

    @Override
    public List<RepaymentEntityDTO> getRepaymentsReceivedByAccount(Long accountId) {
        Account creditorAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Creditor account not found"));
        return repaymentEntityMapper.toDTOList(creditorAccount.getRepaymentsReceived()); // Use the mapper to map entities to DTOs;

    }

    @Override
    public List<RepaymentEntityDTO> getRepaymentsMadeByAccount(Long accountId) {
        Account debtorAccount = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException("Debtor account not found"));
        return repaymentEntityMapper.toDTOList(debtorAccount.getRepaymentsMade()); // Use the mapper to map entities to DTOs;
    }
    // END credit System






    public Account depositAccount(Long accountId, float amountToDepose) throws Exception {
        return null;
    }

    @Override
    public Account save(Account entity) throws Exception {
        return iAccountRepository.save(entity);
    }

    @Override
    public List<Account> saveAll(List<Account> entities) throws Exception {
        return iAccountRepository.saveAll(entities);
    }

    @Override
    public Account getById(Long id) {
        Account account = iAccountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        global.calculateDeposits(account);
        calculateSpendings(account);
        calculateRemainingBalance(account);
        account.setCreditsGiven(null);
        account.setCreditsReceived(null);
        account.setRepaymentsMade(null);
        account.setRepaymentsReceived(null);
        return account;
    }

    @Override
    public List<Account> getAll() {
        List<Account> accounts = iAccountRepository.findAll();
        for (Account item : accounts) {
            global.calculateDeposits(item);
            calculateSpendings(item);
            calculateRemainingBalance(item);
        }
        return accounts;
    }



    public void calculateSpendings(Account account) {
        float amountConsumed = 0;
        List<Spending> spendings = iSpendingRepository.getSpendingsByAccount_Id(account.getId());
        for (Spending spending : spendings) {
            amountConsumed += spending.getAmountToSpend();
        }
        account.setCalculatedAmountconsumed(amountConsumed);
    }

    public void calculateRemainingBalance(Account account) {
        float remainingBalance = account.getCalculatedAmountbalance() - account.getCalculatedAmountconsumed();
        account.setCalculatedAmountRest(remainingBalance);
    }

    @Override
    public void delete(Long id) {
        iAccountRepository.deleteById(id);
    }

    @Override
    public List<Account> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(Account entity) throws ValidationException {

    }

    @Override
    public List<Account> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception {
        return null;
    }
}
