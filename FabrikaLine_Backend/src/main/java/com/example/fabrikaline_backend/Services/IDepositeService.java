package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.Deposite;

import java.util.List;

public interface IDepositeService {
    List<Deposite> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
    Deposite save(Deposite entity, Long param1 ) throws Exception;
    Deposite save(Deposite entity, Long param1,Long param2) throws Exception;
    Deposite save(Deposite entity, Long param1,Long param2,Long param3) throws Exception;
    List<Deposite> getDepositesByAccount(Long accountId) throws Exception;

}
