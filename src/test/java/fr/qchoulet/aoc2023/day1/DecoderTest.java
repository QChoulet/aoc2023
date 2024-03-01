package fr.qchoulet.aoc2023.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoderTest {
    @Test
    void decodeLine_test() {
        String[] inputs = {"1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet"};
        int[] expectedOutputs = { 12, 38, 15, 77 };

        LineDecoder decoder = new LineDecoder();

        for(int i = 0; i < expectedOutputs.length; i++) {
            int output = decoder.decodeLine(inputs[i], false);
            assertEquals(expectedOutputs[i],
                    output,
                    String.format("Input: %s -- Expected: %d -- Actual: %d", inputs[i], expectedOutputs[i], output));
        }
    }

    @Test
    void decodeLine_part2_test() {
        String[] inputs = {"two1nine", "eightwothree", "abcone2threexyz", "xtwone3four", "4nineeightseven2", "zoneight234", "7pqrstsixteen"};
        int[] expectedOutputs = { 29, 83, 13, 24, 42, 14, 76 };

        LineDecoder decoder = new LineDecoder();

        for(int i = 0; i < expectedOutputs.length; i++) {
            int output = decoder.decodeLine(inputs[i], true);
            assertEquals(expectedOutputs[i],
                    output,
                    String.format("Input: %s -- Expected: %d -- Actual: %d", inputs[i], expectedOutputs[i], output));
        }
    }
}