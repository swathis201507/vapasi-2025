package com.tw.splitwise.service;

import com.tw.splitwise.entity.Expense;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ExpenseCalculatorTest {

    private final ExpenseCalculator calculator = new ExpenseCalculator();

    @Test
    void testSingleExpenseDebtCalculation() {
        Expense expense = new Expense("A", 90.0, List.of("A", "B", "C"));
        Map<String, Map<String, Double>> result = calculator.calculateDebts(List.of(expense));

        assertTrue(result.containsKey("A"));
        Map<String, Double> debt = result.get("A");
        assertEquals(2, debt.size());
        assertEquals(30.0, debt.get("B"));
        assertEquals(30.0, debt.get("C"));

    }
}