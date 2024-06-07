package fr.qchoulet.aoc2023.day4;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Card {
    private static final Pattern PATTERN = Pattern.compile("^Card +([0-9]+): +((?:[0-9]+ *)+) \\| +((?:[0-9]+ *)+)$");
    private final int id;
    private final int[] winningNumbers;
    private final int[] numbers;
    private final int score;

    /**
     * @throws IllegalArgumentException if input does not match the pattern ^Card +([0-9]+): +((?:[0-9]+ *)+) \\| +((?:[0-9]+ *)+)$
     */
    public static Card fromInput(String input) {
        if(input == null || input.isEmpty()) return new Card(new int[]{}, new int[]{});

        Matcher matcher = PATTERN.matcher(input);
        if(!matcher.matches()) throw new IllegalArgumentException("Malformed input");

        return new Card(
            Integer.parseInt(matcher.group(1)),
            Arrays.stream(matcher.group(2).split(" +")).map(Integer::parseInt).mapToInt(i->i).toArray(),
            Arrays.stream(matcher.group(3).split(" +")).map(Integer::parseInt).mapToInt(i->i).toArray()
        );
    }

    public Card(int[] winningNumbers, int[] numbers) {
        this(0, winningNumbers, numbers);
    }

    public Card(int id, int[] winningNumbers, int[] numbers) {
        this.id = id;
        this.winningNumbers = winningNumbers;
        this.numbers = numbers;
        this.score = computeScore();
    }

    private int computeScore() {
        int count = (int) Arrays.stream(numbers)
                .filter(i -> Arrays.stream(winningNumbers).anyMatch(w -> w == i))
                .count();

        if(count == 0) return 0;
        return (int) Math.pow(2, count - 1);
    }

    public int id() {
        return id;
    }

    public int score() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Card)) return false;

        return id == ((Card) obj).id
            && Arrays.equals(winningNumbers, ((Card) obj).winningNumbers)
            && Arrays.equals(numbers, ((Card) obj).numbers);
    }
}
