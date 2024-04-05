package com.example.fabrikaline_backend.Services;

import com.example.fabrikaline_backend.DTO.CreditEntityDTO;
import com.example.fabrikaline_backend.DTO.RepaymentEntityDTO;
import com.example.fabrikaline_backend.Entities.Account;

import java.util.List;

public interface IAccountService {
    List<Account> advancedSearch(Long currentPos, Long step, String searchCriteria) throws Exception;
    Account depositAccount(Long accountId, float amountToDepose) throws Exception;

    List<CreditEntityDTO> getCreditsGivenByAccount(Long accountId);
    List<CreditEntityDTO> getCreditsReceivedByAccount(Long accountId);
    List<RepaymentEntityDTO> getRepaymentsReceivedByAccount(Long accountId);
    List<RepaymentEntityDTO> getRepaymentsMadeByAccount(Long accountId);
}
