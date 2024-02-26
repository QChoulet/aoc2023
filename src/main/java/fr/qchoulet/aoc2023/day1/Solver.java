package fr.qchoulet.aoc2023.day1;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class Solver {
    public String solve() {
        LineDecoder decoder = new LineDecoder();

        return readInput()
                .map(decoder::decodeLine)
                .reduce(0, Integer::sum)
                .toString();
    }

    private Stream<String> readInput() {
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource("inputs/day1_1.txt")).toURI());
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
