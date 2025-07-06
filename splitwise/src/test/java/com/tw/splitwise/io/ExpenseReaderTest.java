package com.tw.splitwise.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ExpenseReaderTest {

    @Test
    void testReadLinesFromFile() throws IOException {
        File tempFile = File.createTempFile("expenses", ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("A spent 100 for Snacks for A, B, C\n");
            writer.write("B spent 50 for Taxi for B, C");
        }

        ExpenseReader reader = new ExpenseReader(tempFile.getAbsolutePath());
        List<String> lines = reader.readLines();

        assertEquals(2, lines.size());
        assertEquals("A spent 100 for Snacks for A, B, C", lines.get(0));
        assertEquals("B spent 50 for Taxi for B, C", lines.get(1));

    }
}
