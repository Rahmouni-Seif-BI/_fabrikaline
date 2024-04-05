package com.example.fabrikaline_backend.Services;


import com.example.fabrikaline_backend.Entities.CreditEntity;
import com.example.fabrikaline_backend.Entities.Spending;

import java.util.List;

public interface ICreditEntityService {
    List<CreditEntity> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;

    CreditEntity save(CreditEntity entity, Long param1 ) throws Exception;
    CreditEntity save(CreditEntity entity, Long param1,Long param2) throws Exception;
    CreditEntity save(CreditEntity entity, Long param1,Long param2,Long param3) throws Exception;
}
