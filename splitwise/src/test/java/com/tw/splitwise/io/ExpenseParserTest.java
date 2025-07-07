package com.tw.splitwise.io;

import com.tw.splitwise.entity.Expense;
import com.tw.splitwise.exception.ExpenseParserException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseParserTest {

    private final ExpenseParser parser = new ExpenseParser();

    @Test
    void testParseValidExpense() throws ExpenseParserException {
        String line = "A spent 100 for Snacks for A, B, C";

        Expense expense = parser.parse(line);

        assertEquals("A", expense.getPayer());
        assertEquals(100.0, expense.getAmount());
        assertEquals(List.of("A", "B", "C"), expense.getBeneficiaries());
    }

    @Test
    void testParseWithExtraSpaces() throws ExpenseParserException {
        String line = "  B  spent   250  for  Taxi  for   D, E  ";

        Expense expense = parser.parse(line);

        assertEquals("B", expense.getPayer());
        assertEquals(250.0, expense.getAmount());
        assertEquals(List.of("D", "E"), expense.getBeneficiaries());
    }

    @Test
    void testParseThrowsExceptionForNullInput() {
        Exception e = assertThrows(ExpenseParserException.class, () -> parser.parse(null));
        assertEquals("Input line is null or empty", e.getMessage());
    }

    @Test
    void testParseThrowsExceptionForBlankInput() {
        Exception e = assertThrows(ExpenseParserException.class, () -> parser.parse("   "));
        assertEquals("Input line is null or empty", e.getMessage());
    }

    @Test
    void testParseThrowsExceptionForMissingFields() {
        Exception e = assertThrows(ExpenseParserException.class, () -> parser.parse("A spent 100"));
        assertTrue(e.getMessage().startsWith("Invalid format"));
    }

    @Test
    void testParseThrowsExceptionForMissingPayer() {
        Exception e = assertThrows(ExpenseParserException.class, () -> parser.parse(" spent 100 for Snacks for A, B"));
        assertEquals("Missing Payer Information", e.getMessage());
    }

    @Test
    void testParseThrowsExceptionForNegativeAmount() {
        Exception e = assertThrows(ExpenseParserException.class, () -> parser.parse("A spent -50 for Snacks for B, C"));
        assertEquals("Amount must be positive", e.getMessage());
    }

    @Test
    void testParseThrowsExceptionForZeroAmount() {
        Exception e = assertThrows(ExpenseParserException.class, () -> parser.parse("A spent 0 for Snacks for B, C"));
        assertEquals("Amount must be positive", e.getMessage());
    }

    @Test
    void testParseThrowsExceptionForNonNumericAmount() {
        Exception e = assertThrows(ExpenseParserException.class, () -> parser.parse("A spent abc for Snacks for B, C"));
        assertEquals("Invalid Number Format", e.getMessage());
    }
}
