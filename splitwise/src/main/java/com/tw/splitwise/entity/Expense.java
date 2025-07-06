package com.tw.splitwise.entity;

import java.util.List;

public class Expense {

    private final String payer;
    private final double amount;
    private final List<String> beneficiaries;

    public Expense(String payer, double amount, List<String> beneficiaries) {
        this.payer = payer;
        this.amount = amount;
        this.beneficiaries = beneficiaries;
    }

    public String getPayer() {
        return payer;
    }

    public double getAmount() {
        return amount;
    }

    public List<String> getBeneficiaries() {
        return beneficiaries;
    }
}
