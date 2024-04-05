package com.example.fabrikaline_backend.DTO;

import com.example.fabrikaline_backend.Entities.Account;
import java.time.LocalDate;

public class CreditEntityDTO {
    private Long id;
    private AccountDTO creditorAccount;
    private AccountDTO debtorAccount;
    private double amount;
    private double interestRate;
    private LocalDate startDate;
    private LocalDate endDate;

    @Override
    public String toString() {
        return "CreditEntityDTO{" +
                "id=" + id +
                ", creditorAccount=" + creditorAccount +
                ", debtorAccount=" + debtorAccount +
                ", amount=" + amount +
                ", interestRate=" + interestRate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    public CreditEntityDTO(Long id, AccountDTO creditorAccount, AccountDTO debtorAccount, double amount, double interestRate, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.creditorAccount = creditorAccount;
        this.debtorAccount = debtorAccount;
        this.amount = amount;
        this.interestRate = interestRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CreditEntityDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public AccountDTO getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(AccountDTO creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public AccountDTO getDebtorAccount() {
        return debtorAccount;
    }

    public void setDebtorAccount(AccountDTO debtorAccount) {
        this.debtorAccount = debtorAccount;
    }
}


