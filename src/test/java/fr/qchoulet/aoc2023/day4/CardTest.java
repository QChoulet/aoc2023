package fr.qchoulet.aoc2023.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CardTest {
    @Test
    void fromInput() {
        String input = "Card 1:  5 512 12 | 42 56  1 75 999";

        Card expected = new Card(
                new int[]{5, 512, 12},
                new int[]{42, 56, 1, 75, 999}
        );

        Card result = Card.fromInput(input);
        assertEquals(expected, result);
    }

    @Test
    void fromInput_when_malformedString_throws() {
        assertThrows(IllegalArgumentException.class, () -> Card.fromInput("Some garbage input"));
    }

    @Test
    void fromInput_when_nullOrEmpty_emptyCard() {
        Card emptyCard = new Card(new int[]{}, new int[]{});
        assertEquals(emptyCard, Card.fromInput(null));
        assertEquals(emptyCard, Card.fromInput(""));
    }

    @Test
    void score_when_noWinningNumbers_then_0() {
        Card card = new Card(
            new int[]{1, 2, 3},
            new int[]{10, 11, 12}
        );

        assertEquals(0, card.score());
    }

    @Test
    void score_when_oneWinningNumber_then_1() {
        Card card = new Card(
                new int[]{1, 2, 3},
                new int[]{1, 11, 12}
        );

        assertEquals(1, card.score());
    }

    @Test
    void score() {
        Card card = new Card(
                new int[]{1, 2, 3, 4},
                new int[]{10, 1, 25, 32, 2, 4, 3}
        );

        assertEquals(8, card.score());
    }
}
