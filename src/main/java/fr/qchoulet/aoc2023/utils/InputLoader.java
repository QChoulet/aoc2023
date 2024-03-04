package fr.qchoulet.aoc2023.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Stream;

public class InputLoader {
    public static Stream<String> readLines(String day) {
        String name = "day"+ day +".txt";
        try {
            Path path = Paths.get(Objects.requireNonNull(InputLoader.class.getResource("/inputs/"+ name)).toURI());
            return Files.lines(path);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
