package com.example.fabrikaline_backend.Entities;

import com.example.fabrikaline_backend.Repositories.IAccountRepository;
import com.example.fabrikaline_backend.Repositories.IDepositeRepository;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Account implements Serializable {



    private  static  final long serialVersionUID = 1L ;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String description;
    private String owner;
    private double amountbalance; // Prix li f account ex: 500.000dt (li kol chhar bech yzid)
    private double amountconsumed; // Prix li tconsoma
    private double amountRest; // reste (amountbalance - amountconsumed)
    @Transient
    private float calculatedAmountbalance; //ok
    @Transient
    private float calculatedAmountconsumed;
    @Transient
    private float calculatedAmountRest;


    //Credit Management System!

    @OneToMany(mappedBy = "creditorAccount")
    private List<CreditEntity> creditsGiven;

    @OneToMany(mappedBy = "debtorAccount")
    private List<CreditEntity> creditsReceived;

    @OneToMany(mappedBy = "creditorAccount")
    private List<RepaymentEntity> repaymentsReceived;

    @OneToMany(mappedBy = "debtorAccount")
    private List<RepaymentEntity> repaymentsMade;

    // END Credit Management System!


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getAmountbalance() {
        return amountbalance;
    }

    public void setAmountbalance(double amountbalance) {
        this.amountbalance = amountbalance;
    }

    public double getAmountconsumed() {
        return amountconsumed;
    }

    public void setAmountconsumed(double amountconsumed) {
        this.amountconsumed = amountconsumed;
    }

    public double getAmountRest() {
        return amountRest;
    }

    public void setAmountRest(double amountRest) {
        this.amountRest = amountRest;
    }

    public float getCalculatedAmountbalance() {
        return calculatedAmountbalance;
    }

    public void setCalculatedAmountbalance(float calculatedAmountbalance) {
        this.calculatedAmountbalance = calculatedAmountbalance;
    }

    public float getCalculatedAmountconsumed() {
        return calculatedAmountconsumed;
    }

    public void setCalculatedAmountconsumed(float calculatedAmountconsumed) {
        this.calculatedAmountconsumed = calculatedAmountconsumed;
    }

    public float getCalculatedAmountRest() {
        return calculatedAmountRest;
    }

    public void setCalculatedAmountRest(float calculatedAmountRest) {
        this.calculatedAmountRest = calculatedAmountRest;
    }

    public List<CreditEntity> getCreditsGiven() {
//        List<>
//        for (CreditEntity creditEntity : creditsGiven){
//            creditEntity.
//        }
        return creditsGiven;
    }

    public void setCreditsGiven(List<CreditEntity> creditsGiven) {
        this.creditsGiven = creditsGiven;
    }

    public List<CreditEntity> getCreditsReceived() {
        return creditsReceived;
    }

    public void setCreditsReceived(List<CreditEntity> creditsReceived) {
        this.creditsReceived = creditsReceived;
    }

    public List<RepaymentEntity> getRepaymentsReceived() {
        return repaymentsReceived;
    }

    public void setRepaymentsReceived(List<RepaymentEntity> repaymentsReceived) {
        this.repaymentsReceived = repaymentsReceived;
    }

    public List<RepaymentEntity> getRepaymentsMade() {
        return repaymentsMade;
    }

    public void setRepaymentsMade(List<RepaymentEntity> repaymentsMade) {
        this.repaymentsMade = repaymentsMade;
    }



}
