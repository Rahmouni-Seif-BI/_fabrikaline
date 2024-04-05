package com.example.fabrikaline_backend.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Spending implements Serializable {

    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String notes; // ken fama haja theb tnoteha
    private float amountToSpend; // 9adech khdhit
    private Date actionDate; // wa9tech  khdhit

    // purpose ( hjema, mekla, coffe...)
    @ManyToOne
    @JoinColumn(name = "purpose_id")
    private Purpose purpose;

    // status (khdhit, bech nekhou, batalt, ... )
    @ManyToOne
    @JoinColumn(name = "creditStatus_id")
    private CreditStatus creditStatus;

    // Account
    @ManyToOne
//    @JsonBackReference
    Account account;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public float getAmountToSpend() {
        return amountToSpend;
    }

    public void setAmountToSpend(float amountToSpend) {
        this.amountToSpend = amountToSpend;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public CreditStatus getCreditStatus() {
        return creditStatus;
    }

    public void setCreditStatus(CreditStatus creditStatus) {
        this.creditStatus = creditStatus;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
