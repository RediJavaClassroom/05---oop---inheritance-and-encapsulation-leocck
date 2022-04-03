package com.redi.j2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Step4Tests {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private ByteArrayOutputStream setUpStream() {
        System.setOut(new PrintStream(outContent));
        return outContent;
    }

    @AfterEach
    void restoreStream() {
        System.setOut(originalOut);
    }

    @Test
    void task_4_shouldCopyTheProvidedCode() throws IOException {

        // given - the first and last outputs from the provided code
        String match = "----------------------------------";

        // and - an output sniffer
        setUpStream();

        // when - we run the main function
        Main.main(null);

        // then - the first printed line must match
        BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(outContent.toByteArray())));
        String output = reader.readLine();
        assertTrue(match.equals(output), "Please copy the provided code to your Main class");

        // and - the last printed line must match as well
        String lastLine = output;
        while (output != null) {
            output = reader.readLine();
            if (output != null) {
                lastLine = output;
            }
        }
        assertTrue(match.equals(lastLine), "Please copy the provided code to your Main class");
    }
}
