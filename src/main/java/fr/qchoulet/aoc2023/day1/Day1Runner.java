package fr.qchoulet.aoc2023.day1;

import processing.core.PApplet;

public class Day1Runner {
    public static void main(String... args) {
        Solver solver = new Solver();
        System.out.printf("Part 1 : %s%n", solver.solve_part1());
        System.out.printf("Part 2 : %s%n", solver.solve_part2());

        PApplet.main("fr.qchoulet.aoc2023.day1.animated.AnimatedSolver");
    }
}
