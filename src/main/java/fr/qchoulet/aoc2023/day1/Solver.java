package fr.qchoulet.aoc2023.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class Solver {
    public String solve_part1() {
        LineDecoder decoder = new LineDecoder();

        return readInput("1")
                .map(s -> decoder.decodeLine(s, false))
                .reduce(0, Integer::sum)
                .toString();
    }

    public String solve_part2() {
        LineDecoder decoder = new LineDecoder();

        return readInput("1")
                .map(s -> decoder.decodeLine(s, true))
                .reduce(0, Integer::sum)
                .toString();
    }

    private Stream<String> readInput(String day) {
        String name = "day"+ day +".txt";
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("inputs/"+ name)).toURI());
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
