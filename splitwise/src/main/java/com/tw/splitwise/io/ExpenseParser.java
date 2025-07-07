package com.tw.splitwise.io;

import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.exception.ExpenseParserException;
import java.util.*;

public class ExpenseParser {

    public Expense parse(String line) throws ExpenseParserException {

        if (line == null || line.isBlank()) {
            throw new ExpenseParserException("Input line is null or empty");
        }
        String[] parts = line.split(" spent | for ", 4);

        if (parts.length < 4) {
            throw new ExpenseParserException("Invalid format: " + line);
        }

        try {
            String payer = parts[0].trim();
            if (payer.isEmpty()) {
                throw new ExpenseParserException("Missing Payer Information");
            }
            double amount = Double.parseDouble(parts[1].trim());

            if (amount <= 0) {
                throw new ExpenseParserException("Amount must be positive");
            }
            String[] beneficiaryArr = parts[3].split(",");
            List<String> beneficiaries = Arrays.stream(beneficiaryArr)
                    .map(String::trim)
                    .toList();
            return new Expense(payer, amount, beneficiaries);
        } catch (NumberFormatException e) {
            throw new ExpenseParserException("Invalid Number Format");
        }
    }
}
