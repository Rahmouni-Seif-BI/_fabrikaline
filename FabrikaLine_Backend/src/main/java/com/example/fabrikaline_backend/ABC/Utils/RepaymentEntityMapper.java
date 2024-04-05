package com.example.fabrikaline_backend.ABC.Utils;

import com.example.fabrikaline_backend.DTO.AccountDTO;
import com.example.fabrikaline_backend.DTO.RepaymentEntityDTO;
import com.example.fabrikaline_backend.Entities.Account;
import com.example.fabrikaline_backend.Entities.RepaymentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RepaymentEntityMapper {

    public RepaymentEntityDTO toDTO(RepaymentEntity repaymentEntity) {
        Account creditorAccount = repaymentEntity.getCreditorAccount();
        Account debtorAccount = repaymentEntity.getDebtorAccount();


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

            return new RepaymentEntityDTO(
                repaymentEntity.getId(),
                creditorAccountDTO,
                debtorAccountDTO,
                repaymentEntity.getAmountRepaid(),
                repaymentEntity.getRepaymentDate()
                );
    }

    public List<RepaymentEntityDTO> toDTOList(List<RepaymentEntity> creditEntities) {
        List<RepaymentEntityDTO> repaymentEntityDTOs = new ArrayList<>();
        for (RepaymentEntity repaymentEntity : creditEntities) {
            repaymentEntityDTOs.add(toDTO(repaymentEntity));
        }
        return repaymentEntityDTOs;
    }
}

