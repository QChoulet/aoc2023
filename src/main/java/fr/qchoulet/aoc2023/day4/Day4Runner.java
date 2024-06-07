package fr.qchoulet.aoc2023.day4;

import fr.qchoulet.aoc2023.utils.InputLoader;

import java.util.stream.Stream;

public class Day4Runner {
    public static void main(String... args) {
        Solver solver = new Solver();

        try(Stream<String> input = InputLoader.readLines("4")) {
            System.out.printf("Part 1 : %s%n", solver.solve_part1(input));
        }
    }
}
