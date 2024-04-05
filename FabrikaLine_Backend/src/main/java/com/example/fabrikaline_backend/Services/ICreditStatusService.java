package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.CreditStatus;

import java.util.List;

public interface ICreditStatusService {
    List<CreditStatus> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
}
