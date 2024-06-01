package fr.qchoulet.aoc2023.day3;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolverTest {
    @Test
    public void part1() {
        Stream<String> input = Stream.of(
        "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."
        );

        long expected = 4361;
        Solver solver = new Solver();
        assertEquals(expected, solver.solve_part1(input));
    }
}
