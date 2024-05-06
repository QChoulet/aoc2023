package fr.qchoulet.aoc2023.day2;

import java.util.ArrayList;
import java.util.List;

public class LineDecoder {
    public Game parseLine(String line) {
        String[] splitGameAndSets = line.split(":");
        int gameId = Integer.parseInt(splitGameAndSets[0].replace("Game ", ""));

        String[] setStrings = splitGameAndSets[1].split(";");
        List<Game.Set> sets = new ArrayList<>();

        for(String setString: setStrings) {
            sets.add(parseSet(setString));
        }

        return new Game(gameId, sets);
    }

    public Game.Set parseSet(String setString) {
        int red = 0, green = 0, blue = 0;

        if(setString.contains("red")) {
            red = Integer.parseInt(setString.replaceAll(".*?([0-9]+) red.*","$1"));
        }
        if(setString.contains("green")) {
            green = Integer.parseInt(setString.replaceAll(".*?([0-9]+) green.*","$1"));
        }
        if(setString.contains("blue")) {
            blue  = Integer.parseInt(setString.replaceAll(".*?([0-9]+) blue.*","$1"));
        }

        return new Game.Set(red, green, blue);
    }
}
