package com.tw.splitwise.io;

import com.tw.splitwise.entity.Expense;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseParserTest {

    private final ExpenseParser parser = new ExpenseParser();

    @Test
    void testValidLineParsing() {
        String line = "A spent 100 for Snacks for A, B, C";
        Optional<Expense> result = parser.parse(line);

        assertTrue(result.isPresent());
        Expense expense = result.get();
        assertEquals("A", expense.getPayer());
        assertEquals(100.0, expense.getAmount());
        assertEquals(List.of("A", "B", "C"), expense.getBeneficiaries());
    }

    @Test
    void testInvalidLineFormatReturnsEmpty() {
        String line = "Invalid input line";
        Optional<Expense> result = parser.parse(line);
        assertTrue(result.isEmpty());
    }

    @Test
    void testInvalidAmountReturnsEmpty() {
        String line = "B spent abc for Taxi for B, C";
        Optional<Expense> result = parser.parse(line);
        assertTrue(result.isEmpty());
    }
}


