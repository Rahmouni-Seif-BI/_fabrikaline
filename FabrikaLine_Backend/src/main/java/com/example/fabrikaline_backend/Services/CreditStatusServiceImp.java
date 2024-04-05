package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.CreditStatus;
import com.example.fabrikaline_backend.Entities.CreditStatus;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.ICreditStatusRepository;
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
public class CreditStatusServiceImp implements ICreditStatusService, IAbstractService<CreditStatus> {

    @Autowired
    ICreditStatusRepository iCreditStatusRepository;

    @Override
    public CreditStatus save(CreditStatus entity) throws Exception {
        return iCreditStatusRepository.save(entity);
    }

    @Override
    public List<CreditStatus> saveAll(List<CreditStatus> entities) throws Exception {
        return iCreditStatusRepository.saveAll(entities);
    }

    @Override
    public CreditStatus getById(Long id) {

        return iCreditStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<CreditStatus> getAll() {
        return iCreditStatusRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        iCreditStatusRepository.deleteById(id);
    }

    @Override
    public List<CreditStatus> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(CreditStatus entity) throws ValidationException {

    }

    @Override
    public List<CreditStatus> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception {
        return null;
    }
}
