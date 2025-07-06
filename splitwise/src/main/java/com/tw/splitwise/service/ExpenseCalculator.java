package com.tw.splitwise.service;

import com.tw.splitwise.entity.Expense;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ExpenseCalculator {
    public Map<String, Map<String, Double>> calculateDebts(List<Expense> expenses) {
        Map<String, Map<String, Double>> debtMap = new HashMap<>();

        for (Expense expense : expenses) {
            String payer = expense.getPayer();
            double splitAmount = expense.getAmount() / expense.getBeneficiaries().size();

            debtMap.putIfAbsent(payer, new HashMap<>());

            for (String beneficiary : expense.getBeneficiaries()) {
                if (!beneficiary.equals(payer)) {
                    debtMap.get(payer).merge(beneficiary, splitAmount, Double::sum);
                }
            }
        }

        return debtMap;
    }
}
