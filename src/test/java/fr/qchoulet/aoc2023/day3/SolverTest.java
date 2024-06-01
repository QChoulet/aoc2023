package fr.qchoulet.aoc2023.day3;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolverTest {
    @Test
    public void part1() {
        Stream<String> input = Stream.of("",
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

    @Test
    public void part2() {
        Stream<String> input = Stream.of("",
                "467..114..",
                "...*......", // is a gear with ratio 16345
                "..35..633.",
                "......#...",
                "617*......", // not a gear, only 1 part
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....", // is a gear with ratio 451490
                ".664.598..",
                ".664*598.." // not a gear, more than 2 parts
        );

        long expected = 467835;
        Solver solver = new Solver();
        assertEquals(expected, solver.solve_part2(input));
    }
}
