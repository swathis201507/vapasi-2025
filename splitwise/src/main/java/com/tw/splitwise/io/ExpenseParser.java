package com.tw.splitwise.io;

import com.tw.splitwise.entity.Expense;

import java.util.*;
import java.util.logging.Logger;

public class ExpenseParser {
    private static final Logger logger = Logger.getLogger(ExpenseParser.class.getName());

    public Expense parse(String line) {
        String[] parts = line.split(" spent | for ", 4);

        if (parts.length < 4) {
            logger.info("Invalid format: " + line);
            return null;
        }

        try {
            String payer = parts[0].trim();
            double amount = Double.parseDouble(parts[1].trim());
            String[] beneficiaryArr = parts[3].split(",");
            List<String> beneficiaries = Arrays.stream(beneficiaryArr)
                    .map(String::trim)
                    .toList();
            return new Expense(payer, amount, beneficiaries);
        } catch (NumberFormatException e) {
            logger.severe("Invalid amount in line: " + line);
            return null;
        }
    }
}

