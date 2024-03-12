package fr.qchoulet.aoc2023.day2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineDecoderTest {
    @Test
    public void parseLine_oneSet() {
        String line = "Game 1: 1 red, 2 green, 6 blue";
        Game expected = new Game(1, List.of(new Game.Set(1, 2, 6)));

        Game output = new LineDecoder().parseLine(line);

        assertEquals(expected.id(), output.id());
        assertEquals(expected.sets().size(), output.sets().size());
        for(int i = 0; i < expected.sets().size(); i++) {
            assertEquals(expected.sets().get(i), output.sets().get(i));
        }
    }

    @Test
    public void parseLine_oneSetMissingColors() {
        String line = "Game 1: 1 red, 6 blue";
        Game expected = new Game(1, List.of(new Game.Set(1, 0, 6)));

        Game output = new LineDecoder().parseLine(line);

        assertEquals(expected.id(), output.id());
        assertEquals(expected.sets().size(), output.sets().size());
        for(int i = 0; i < expected.sets().size(); i++) {
            assertEquals(expected.sets().get(i), output.sets().get(i));
        }
    }

    @Test
    public void parseLine_multipleSets() {
        String line = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green";
        Game expected = new Game(1, List.of(
                new Game.Set(4, 0, 3),
                new Game.Set(1, 2, 6),
                new Game.Set(0, 2, 0)
        ));

        Game output = new LineDecoder().parseLine(line);

        assertEquals(expected.id(), output.id());
        assertEquals(expected.sets().size(), output.sets().size());
        for(int i = 0; i < expected.sets().size(); i++) {
            assertEquals(expected.sets().get(i), output.sets().get(i));
        }
    }
}
