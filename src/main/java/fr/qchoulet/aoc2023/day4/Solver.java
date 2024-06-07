package fr.qchoulet.aoc2023.day4;

import java.util.stream.Stream;

public class Solver {
    public int solve_part1(Stream<String> input) {
        return input.map(Card::fromInput)
                .mapToInt(Card::score)
                .sum();
    }
}
