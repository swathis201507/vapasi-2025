package com.tw.splitwise.app;

import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.io.ConfigLoader;
import com.tw.splitwise.io.ExpenseParser;
import com.tw.splitwise.io.ExpenseReader;
import com.tw.splitwise.service.ExpenseCalculator;
import com.tw.splitwise.service.ExpensePrinter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitWiseMain {

    public static void main(String[] args) {

        String filePath = ConfigLoader.getFilePath();
        ExpenseReader reader = new ExpenseReader(filePath);
        ExpenseParser parser = new ExpenseParser();
        ExpenseCalculator calculator = new ExpenseCalculator();
        ExpensePrinter printer = new ExpensePrinter();

        try {
            List<String> lines = reader.readLines();
            List<Expense> expenses = new ArrayList<>();
            for (String line : lines) {
                parser.parse(line).ifPresent(expenses::add);
            }

            Map<String, Map<String, Double>> debtMap = calculator.calculateDebts(expenses);
            printer.printDebts(debtMap);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
