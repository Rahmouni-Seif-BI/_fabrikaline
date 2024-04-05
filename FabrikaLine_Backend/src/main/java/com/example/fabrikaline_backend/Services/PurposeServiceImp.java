package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.ABC.IAbstractService;
import com.example.fabrikaline_backend.Entities.Purpose;
import com.example.fabrikaline_backend.Models.SearchCriteria;
import com.example.fabrikaline_backend.Repositories.IPurposeRepository;
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
public class PurposeServiceImp implements IPurposeService, IAbstractService<Purpose> {

    @Autowired
    IPurposeRepository iPurposeRepository;

    @Override
    public Purpose save(Purpose entity) throws Exception {
        return iPurposeRepository.save(entity);
    }

    @Override
    public List<Purpose> saveAll(List<Purpose> entities) throws Exception {
        return iPurposeRepository.saveAll(entities);
    }

    @Override
    public Purpose getById(Long id) {

        return iPurposeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Item with id :" + id + " not found"));
    }

    @Override
    public List<Purpose> getAll() {
        return iPurposeRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        iPurposeRepository.deleteById(id);
    }

    @Override
    public List<Purpose> search(SearchCriteria criteria) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void validate(Purpose entity) throws ValidationException {

    }

    @Override
    public List<Purpose> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception {
        return null;
    }
}
