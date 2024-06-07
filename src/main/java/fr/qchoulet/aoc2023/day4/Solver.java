package fr.qchoulet.aoc2023.day4;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Solver {
    public int solve_part1(Stream<String> input) {
        return input.map(Card::fromInput)
                .mapToInt(Card::score)
                .sum();
    }

    public int solve_part2(Stream<String> input) {
        List<Card> originalCards = input.map(Card::fromInput).toList();

        Map<Integer, Integer> counts = HashMap.newHashMap(originalCards.size());
        // At first we have one card of each (the originals)
        for(int i = 1; i <= originalCards.size(); i++) {
            counts.put(i, 1);
        }

        // Then we generate copies from both originals and copies
        // Because cards will never make copies of cards with a lower id, we can process cards in ascending id order
        // and avoid any recursion
        for(Card card: originalCards) {
            if(card.matches() == 0) continue;

            int copyStart = card.id() + 1;
            int copyEnd = Math.min(card.id() + card.matches(), originalCards.size());
            int copiesCount = counts.get(card.id());

            for(int i = copyStart; i <= copyEnd; i++) {
                counts.put(i, counts.get(i) + copiesCount);
            }
        }

        return counts.values().stream().mapToInt(i -> i).sum();
    }
}
