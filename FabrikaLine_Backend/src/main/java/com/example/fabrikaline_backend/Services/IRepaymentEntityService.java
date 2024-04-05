package com.example.fabrikaline_backend.Services;


import com.example.fabrikaline_backend.Entities.RepaymentEntity;
import com.example.fabrikaline_backend.Entities.RepaymentEntity;

import java.util.List;

public interface IRepaymentEntityService {
    List<RepaymentEntity> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;

    RepaymentEntity save(RepaymentEntity entity, Long param1 ) throws Exception;
    RepaymentEntity save(RepaymentEntity entity, Long param1,Long param2) throws Exception;
    RepaymentEntity save(RepaymentEntity entity, Long param1,Long param2,Long param3) throws Exception;
}
