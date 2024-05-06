package fr.qchoulet.aoc2023.day2;

import fr.qchoulet.aoc2023.utils.InputLoader;

import java.util.stream.Stream;

public class Day2Runner {
    public static void main(String... args) {
        Solver solver = new Solver();

        try(Stream<String> input = InputLoader.readLines("2")) {
            System.out.printf("Part 1 : %s%n", solver.solve_part1(input, new Game.Set(12, 13, 14)));
        }

        try(Stream<String> input = InputLoader.readLines("2")) {
            System.out.printf("Part 2 : %s%n", solver.solve_part2(input));
        }
    }
}
