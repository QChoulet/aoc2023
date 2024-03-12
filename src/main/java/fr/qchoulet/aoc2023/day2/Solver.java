package fr.qchoulet.aoc2023.day2;

import fr.qchoulet.aoc2023.utils.InputLoader;

import java.util.stream.Stream;

public class Solver {
    public String solve_part1(Stream<String> input) {
        LineDecoder decoder = new LineDecoder();
        Game.Set bagContent = new Game.Set(12, 13, 14);

        return input.map(decoder::parseLine)
                .filter(game -> !isGamePossible(game, bagContent))
                .map(Game::id)
                .reduce(0, Integer::sum)
                .toString();
    }

    private boolean isGamePossible(Game game, Game.Set bagContent) {
        for(Game.Set set : game.sets()) {
            if(set.red() > bagContent.red() || set.green() > bagContent.green() || set.blue() > bagContent.blue()) {
                return false;
            }
        }
        return true;
    }
}
