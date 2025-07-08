package com.tw.splitwise.service;

import java.util.Map;

public class ExpensePrinter {

    public void printDebts(Map<String, Map<String, Double>> debtMap) {
        for (var creditorEntry : debtMap.entrySet()) {
            String creditor = creditorEntry.getKey();
            for (var debtorEntry : creditorEntry.getValue().entrySet()) {
                System.out.printf("%s owes %s amount- %.2f%n", " "+debtorEntry.getKey(), creditor, debtorEntry.getValue());
            }
        }
    }
}
