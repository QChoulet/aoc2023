package fr.qchoulet.aoc2023.day3;

import fr.qchoulet.aoc2023.utils.InputLoader;

import java.util.stream.Stream;

public class Day3Runner {
    public static void main(String... args) {
        Solver solver = new Solver();

        try(Stream<String> input = InputLoader.readLines("3")) {
            System.out.printf("Part 1 : %s%n", solver.solve_part1(input));
        }
        try(Stream<String> input = InputLoader.readLines("3")) {
            System.out.printf("Part 2 : %s%n", solver.solve_part2(input));
        }
    }
}
