package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.CreditStatus;
import com.example.fabrikaline_backend.Entities.Purpose;

import java.util.List;

public interface IPurposeService {
    List<Purpose> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
