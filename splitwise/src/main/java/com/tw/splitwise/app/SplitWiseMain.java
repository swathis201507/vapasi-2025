package com.tw.splitwise.app;

import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.io.ExpenseParser;
import com.tw.splitwise.io.ExpenseReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SplitWiseMain {

    public static void main(String[] args) {

        String filePath = "/Users/swathis/IdeaProjects/vapasi-2025/splitwise/src/main/resources/expenses.txt";
        ExpenseReader reader = new ExpenseReader(filePath);
        ExpenseParser parser = new ExpenseParser();

        try {
            List<String> lines = reader.readLines();
            List<Expense> expenses = new ArrayList<>();
            for (String line : lines) {
                parser.parse(line).ifPresent(expenses::add);
            }

            System.out.println(expenses);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
