package com.example.fabrikaline_backend.DTO;

import com.example.fabrikaline_backend.Entities.Account;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class RepaymentEntityDTO {
    private Long id;
    private AccountDTO creditorAccountDTO;
    private AccountDTO debtorAccountDTO;
    private double amountRepaid;
    private LocalDate repaymentDate;

    public RepaymentEntityDTO() {
    }

    public RepaymentEntityDTO(Long id, AccountDTO creditorAccountDTO, AccountDTO debtorAccountDTO, double amountRepaid, LocalDate repaymentDate) {
        this.id = id;
        this.creditorAccountDTO = creditorAccountDTO;
        this.debtorAccountDTO = debtorAccountDTO;
        this.amountRepaid = amountRepaid;
        this.repaymentDate = repaymentDate;
    }

    @Override
    public String toString() {
        return "RepaymentEntityDTO{" +
                "id=" + id +
                ", creditorAccountDTO=" + creditorAccountDTO +
                ", debtorAccountDTO=" + debtorAccountDTO +
                ", amountRepaid=" + amountRepaid +
                ", repaymentDate=" + repaymentDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountDTO getCreditorAccountDTO() {
        return creditorAccountDTO;
    }

    public void setCreditorAccountDTO(AccountDTO creditorAccountDTO) {
        this.creditorAccountDTO = creditorAccountDTO;
    }

    public AccountDTO getDebtorAccountDTO() {
        return debtorAccountDTO;
    }

    public void setDebtorAccountDTO(AccountDTO debtorAccountDTO) {
        this.debtorAccountDTO = debtorAccountDTO;
    }

    public double getAmountRepaid() {
        return amountRepaid;
    }

    public void setAmountRepaid(double amountRepaid) {
        this.amountRepaid = amountRepaid;
    }

    public LocalDate getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(LocalDate repaymentDate) {
        this.repaymentDate = repaymentDate;
    }
}
