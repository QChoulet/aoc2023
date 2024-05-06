package fr.qchoulet.aoc2023.day2;

import fr.qchoulet.aoc2023.day1.animated.Line;
import fr.qchoulet.aoc2023.utils.InputLoader;

import java.util.stream.Stream;

public class Solver {
    public int solve_part1(Stream<String> input, Game.Set bagContent) {
        LineDecoder decoder = new LineDecoder();

        return input.map(decoder::parseLine)
                .filter(game -> isGamePossible(game, bagContent))
                .map(Game::id)
                .reduce(0, Integer::sum);
    }

    public int solve_part2(Stream<String> input) {
        LineDecoder decoder = new LineDecoder();

        return input.map(decoder::parseLine)
                .map(this::minPossibleCubes)
                .map(this::setPower)
                .reduce(0, Integer::sum);
    }

    private boolean isGamePossible(Game game, Game.Set bagContent) {
        for(Game.Set set : game.sets()) {
            if(set.red() > bagContent.red() || set.green() > bagContent.green() || set.blue() > bagContent.blue()) {
                return false;
            }
        }
        return true;
    }

    private Game.Set minPossibleCubes(Game game) {
        Game.Set minSet = new Game.Set(0, 0, 0);

        if(game.sets() == null || game.sets().isEmpty()) {
            return minSet;
        }

        for(Game.Set set : game.sets()) {
            if(set.red() > minSet.red()) {
                minSet = new Game.Set(set.red(), minSet.green(), minSet.blue());
            }
            if(set.green() > minSet.green()) {
                minSet = new Game.Set(minSet.red(), set.green(), minSet.blue());
            }
            if(set.blue() > minSet.blue()) {
                minSet = new Game.Set(minSet.red(), minSet.green(), set.blue());
            }
        }

        return minSet;
    }

    private int setPower(Game.Set set) {
        return set.red() * set.green() * set.blue();
    }
}
