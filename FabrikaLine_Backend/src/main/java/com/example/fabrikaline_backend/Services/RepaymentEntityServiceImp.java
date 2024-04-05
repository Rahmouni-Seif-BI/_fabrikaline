package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.ABC.Utils.RepaymentEntityMapper;
import com.example.fabrikaline_backend.DTO.RepaymentEntityDTO;
import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.RepaymentEntity;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IAccountRepository;
import com.example.fabrikaline_backend.Repositories.IRepaymentEntityRepository;
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
public class RepaymentEntityServiceImp implements IRepaymentEntityService, IAbstractService<RepaymentEntity> {

    @Autowired
    IRepaymentEntityRepository iRepaymentEntityRepository;

    @Autowired
    IAccountRepository iAccountRepository;

    @Autowired
    private RepaymentEntityMapper repaymentEntityMapper;

    @Override
    public RepaymentEntity save(RepaymentEntity entity) throws Exception {
        iRepaymentEntityRepository.save(entity);
        return null;
    }

    @Override
    public RepaymentEntity save(RepaymentEntity entity, Long param1) throws Exception {
        return null;
    }

    @Override
    public RepaymentEntity save(RepaymentEntity entity, Long creditorAccountId, Long debitorAccountId) throws Exception {
        Account creditorAccount = iAccountRepository.getById(creditorAccountId);
        Account debitorAccount = iAccountRepository.getById(debitorAccountId);
        entity.setCreditorAccount(creditorAccount);
        entity.setDebtorAccount(debitorAccount);
         iRepaymentEntityRepository.save(entity);
        return null;
    }


    @Override
    public RepaymentEntity save(RepaymentEntity entity, Long param1, Long param2, Long param3) throws Exception {
        return null;
    }

    @Override
    public List<RepaymentEntity> saveAll(List<RepaymentEntity> entities) throws Exception {
        return iRepaymentEntityRepository.saveAll(entities);
    }

    @Override
    public RepaymentEntity getById(Long id) {

        RepaymentEntity repaymentEntity= iRepaymentEntityRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));

        repaymentEntity.getCreditorAccount().setCreditsGiven(null);
        repaymentEntity.getCreditorAccount().setCreditsReceived(null);
        repaymentEntity.getCreditorAccount().setRepaymentsMade(null);
        repaymentEntity.getCreditorAccount().setRepaymentsReceived(null);

        repaymentEntity.getDebtorAccount().setCreditsGiven(null);
        repaymentEntity.getDebtorAccount().setCreditsReceived(null);
        repaymentEntity.getDebtorAccount().setRepaymentsMade(null);
        repaymentEntity.getDebtorAccount().setRepaymentsReceived(null);

        return repaymentEntity;
    }

    @Override
    public List<RepaymentEntity> getAll() {
        return iRepaymentEntityRepository.findAll();
    }

    public List<RepaymentEntityDTO> getRepaymentEntities() {
        List<RepaymentEntity> repaymentEntityList = iRepaymentEntityRepository.findAll();
        return repaymentEntityMapper.toDTOList(repaymentEntityList); // Use the mapper to map entities to DTOs;
    }

    @Override
    public void delete(Long id) {
        iRepaymentEntityRepository.deleteById(id);
    }

    @Override
    public List<RepaymentEntity> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(RepaymentEntity entity) throws ValidationException {

    }

    @Override
    public List<RepaymentEntity> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception {
        return null;
    }

}
