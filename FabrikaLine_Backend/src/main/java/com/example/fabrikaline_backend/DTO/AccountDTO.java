package com.example.fabrikaline_backend.DTO;


public class AccountDTO {
    private Long id;
    private String code;
    private String description;
    private String owner;
    private double amountBalance;
    private double amountConsumed;
    private double amountRest;
    private float calculatedAmountBalance;
    private float calculatedAmountConsumed;
    private float calculatedAmountRest;

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

    public double getAmountBalance() {
        return amountBalance;
    }

    public void setAmountBalance(double amountBalance) {
        this.amountBalance = amountBalance;
    }

    public double getAmountConsumed() {
        return amountConsumed;
    }

    public void setAmountConsumed(double amountConsumed) {
        this.amountConsumed = amountConsumed;
    }

    public double getAmountRest() {
        return amountRest;
    }

    public void setAmountRest(double amountRest) {
        this.amountRest = amountRest;
    }

    public float getCalculatedAmountBalance() {
        return calculatedAmountBalance;
    }

    public void setCalculatedAmountBalance(float calculatedAmountBalance) {
        this.calculatedAmountBalance = calculatedAmountBalance;
    }

    public float getCalculatedAmountConsumed() {
        return calculatedAmountConsumed;
    }

    public void setCalculatedAmountConsumed(float calculatedAmountConsumed) {
        this.calculatedAmountConsumed = calculatedAmountConsumed;
    }

    public float getCalculatedAmountRest() {
        return calculatedAmountRest;
    }

    public void setCalculatedAmountRest(float calculatedAmountRest) {
        this.calculatedAmountRest = calculatedAmountRest;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", owner='" + owner + '\'' +
                ", amountBalance=" + amountBalance +
                ", amountConsumed=" + amountConsumed +
                ", amountRest=" + amountRest +
                ", calculatedAmountBalance=" + calculatedAmountBalance +
                ", calculatedAmountConsumed=" + calculatedAmountConsumed +
                ", calculatedAmountRest=" + calculatedAmountRest +
                '}';
    }

    public AccountDTO() {
    }

    public AccountDTO(Long id, String code, String description, String owner, float calculatedAmountBalance, float calculatedAmountConsumed, float calculatedAmountRest) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.owner = owner;
        this.calculatedAmountBalance = calculatedAmountBalance;
        this.calculatedAmountConsumed = calculatedAmountConsumed;
        this.calculatedAmountRest = calculatedAmountRest;
    }

    public AccountDTO(Long id, String code, String description, String owner, double amountBalance, double amountConsumed, double amountRest, float calculatedAmountBalance, float calculatedAmountConsumed, float calculatedAmountRest) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.owner = owner;
        this.amountBalance = amountBalance;
        this.amountConsumed = amountConsumed;
        this.amountRest = amountRest;
        this.calculatedAmountBalance = calculatedAmountBalance;
        this.calculatedAmountConsumed = calculatedAmountConsumed;
        this.calculatedAmountRest = calculatedAmountRest;
    }
}
