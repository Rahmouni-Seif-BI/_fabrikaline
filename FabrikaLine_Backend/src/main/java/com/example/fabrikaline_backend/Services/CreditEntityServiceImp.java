package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.ABC.Utils.CreditEntityMapper;
import com.example.fabrikaline_backend.DTO.CreditEntityDTO;
import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.CreditEntity;
import com.example.fabrikaline_backend.Entities.Spending;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IAccountRepository;
import com.example.fabrikaline_backend.Repositories.ICreditEntityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CreditEntityServiceImp implements ICreditEntityService, IAbstractService<CreditEntity> {

    @Autowired
    ICreditEntityRepository iCreditEntityRepository;

    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    private CreditEntityMapper creditEntityMapper;


    @Override
    public CreditEntity save(CreditEntity entity, Long param1) throws Exception {
        return null;
    }

    @Override
    public CreditEntity save(CreditEntity entity,  Long creditorAccountId, Long debitorAccountId) throws Exception {
        Account creditorAccount = iAccountRepository.getById(creditorAccountId);
        Account debitorAccount = iAccountRepository.getById(debitorAccountId);
        entity.setCreditorAccount(creditorAccount);
        entity.setDebtorAccount(debitorAccount);
        iCreditEntityRepository.save(entity);
        return  null;
    }

    @Override
    public CreditEntity save(CreditEntity entity, Long param1, Long param2, Long param3) throws Exception {
        return null;
    }
    @Override
    public CreditEntity save(CreditEntity entity) throws Exception {
        return null;
    }

    @Override
    public List<CreditEntity> saveAll(List<CreditEntity> entities) throws Exception {

        return iCreditEntityRepository.saveAll(entities);
    }

    @Override
    public CreditEntity getById(Long id) {

        CreditEntity creditEntity = iCreditEntityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
        creditEntity.getCreditorAccount().setCreditsGiven(null);
        creditEntity.getCreditorAccount().setCreditsReceived(null);
        creditEntity.getCreditorAccount().setRepaymentsMade(null);
        creditEntity.getCreditorAccount().setRepaymentsReceived(null);

        creditEntity.getDebtorAccount().setCreditsGiven(null);
        creditEntity.getDebtorAccount().setCreditsReceived(null);
        creditEntity.getDebtorAccount().setRepaymentsMade(null);
        creditEntity.getDebtorAccount().setRepaymentsReceived(null);
         return creditEntity;
    }

    @Override
    public List<CreditEntity> getAll() {
       return   iCreditEntityRepository.findAll();
    }

    public List<CreditEntityDTO> getCreditEntities() {
        List<CreditEntity> creditEntities =  iCreditEntityRepository.findAll();
        return creditEntityMapper.toDTOList(creditEntities); // Use the mapper to map entities to DTOs;
    }

    @Override
    public void delete(Long id) {
        iCreditEntityRepository.deleteById(id);
    }

    @Override
    public List<CreditEntity> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(CreditEntity entity) throws ValidationException {

    }

    @Override
    public List<CreditEntity> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception {
        return null;
    }
}
