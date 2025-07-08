package com.tw.splitwise.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class ExpensePrinterTest {

    @Test
    void testDebtPrintsCorrectly() {
        Map<String, Map<String, Double>> debtMap = new HashMap<>();
        Map<String, Double> inner = new HashMap<>();
        inner.put("B", 25.0);
        inner.put("C", 25.0);
        debtMap.put("A", inner);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        new ExpensePrinter().printDebts(debtMap);

        String output = outContent.toString().trim();
        assertTrue(output.contains("B owes A amount- 25.00"));
        assertTrue(output.contains("C owes A amount- 25.00"));
    }
}
