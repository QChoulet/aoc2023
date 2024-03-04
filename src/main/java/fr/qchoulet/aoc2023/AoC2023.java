package fr.qchoulet.aoc2023;

import fr.qchoulet.aoc2023.day1.Solver;
import processing.core.PApplet;

public class AoC2023 {
    public static void main(String... args) {
        Solver solver = new Solver();
        System.out.printf("Part 1 : %s%n", solver.solve_part1());
        System.out.printf("Part 2 : %s%n", solver.solve_part2());

        PApplet.main("fr.qchoulet.aoc2023.day1.animated.AnimatedSolver");
    }
}
