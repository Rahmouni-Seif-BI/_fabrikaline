package com.example.fabrikaline_backend.ABC.Utils;

import com.example.fabrikaline_backend.DTO.AccountDTO;
import com.example.fabrikaline_backend.DTO.CreditEntityDTO;
import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.CreditEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class CreditEntityMapper {

    public CreditEntityDTO toDTO(CreditEntity creditEntity) {
        Account creditorAccount = creditEntity.getCreditorAccount();
        Account debtorAccount = creditEntity.getDebtorAccount();


        AccountDTO creditorAccountDTO = new AccountDTO();
        creditorAccountDTO.setId(creditorAccount.getId());
        creditorAccountDTO.setCode(creditorAccount.getCode());
        creditorAccountDTO.setDescription(creditorAccount.getDescription());
        creditorAccountDTO.setOwner(creditorAccount.getOwner());
        creditorAccountDTO.setAmountBalance(creditorAccount.getAmountbalance());
        creditorAccountDTO.setAmountConsumed(creditorAccount.getAmountconsumed());
        creditorAccountDTO.setAmountRest(creditorAccount.getAmountRest());
        creditorAccountDTO.setCalculatedAmountBalance(creditorAccount.getCalculatedAmountbalance());
        creditorAccountDTO.setCalculatedAmountConsumed(creditorAccount.getCalculatedAmountconsumed());
        creditorAccountDTO.setCalculatedAmountRest(creditorAccount.getCalculatedAmountRest());

        AccountDTO debtorAccountDTO = new AccountDTO();
        debtorAccountDTO.setId(debtorAccount.getId());
        debtorAccountDTO.setCode(debtorAccount.getCode());
        debtorAccountDTO.setDescription(debtorAccount.getDescription());
        debtorAccountDTO.setOwner(debtorAccount.getOwner());
        debtorAccountDTO.setAmountBalance(debtorAccount.getAmountbalance());
        debtorAccountDTO.setAmountConsumed(debtorAccount.getAmountconsumed());
        debtorAccountDTO.setAmountRest(debtorAccount.getAmountRest());
        debtorAccountDTO.setCalculatedAmountBalance(debtorAccount.getCalculatedAmountbalance());
        debtorAccountDTO.setCalculatedAmountConsumed(debtorAccount.getCalculatedAmountconsumed());
        debtorAccountDTO.setCalculatedAmountRest(debtorAccount.getCalculatedAmountRest());

        return new CreditEntityDTO(
                creditEntity.getId(),
                creditorAccountDTO,
                debtorAccountDTO,
                creditEntity.getAmount(),
                creditEntity.getInterestRate(),
                creditEntity.getStartDate(),
                creditEntity.getEndDate()
        );
    }

    public List<CreditEntityDTO> toDTOList(List<CreditEntity> creditEntities) {
        List<CreditEntityDTO> creditEntityDTOs = new ArrayList<>();
        for (CreditEntity creditEntity : creditEntities) {
            creditEntityDTOs.add(toDTO(creditEntity));
        }
        return creditEntityDTOs;
    }
}

