package fr.qchoulet.aoc2023.day1;

import fr.qchoulet.aoc2023.utils.InputLoader;

public class Solver {
    public String solve_part1() {
        LineDecoder decoder = new LineDecoder();

        return InputLoader.readLines("1")
                .map(s -> decoder.decodeLine(s, false))
                .reduce(0, Integer::sum)
                .toString();
    }

    public String solve_part2() {
        LineDecoder decoder = new LineDecoder();

        return InputLoader.readLines("1")
                .map(s -> decoder.decodeLine(s, true))
                .reduce(0, Integer::sum)
                .toString();
    }


}
