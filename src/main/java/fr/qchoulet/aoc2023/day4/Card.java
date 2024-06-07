package fr.qchoulet.aoc2023.day4;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Card {
    private static final Pattern PATTERN = Pattern.compile("^Card +[0-9]+: +((?:[0-9]+ *)+) \\| +((?:[0-9]+ *)+)$");
    private final int[] winningNumbers;
    private final int[] numbers;

    /**
     * @throws IllegalArgumentException if input does not match the pattern ^Card [0-9]+: +((?:[0-9]+ *)+) \\| +((?:[0-9]+ *)+)$
     */
    public static Card fromInput(String input) {
        if(input == null || input.isEmpty()) return new Card(new int[]{}, new int[]{});

        Matcher matcher = PATTERN.matcher(input);
        if(!matcher.matches()) throw new IllegalArgumentException("Malformed input");

        return new Card(
            Arrays.stream(matcher.group(1).split(" +")).map(Integer::parseInt).mapToInt(i->i).toArray(),
            Arrays.stream(matcher.group(2).split(" +")).map(Integer::parseInt).mapToInt(i->i).toArray()
        );
    }

    public Card(int[] winningNumbers, int[] numbers) {
        this.winningNumbers = winningNumbers;
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Card)) return false;

        return Arrays.equals(winningNumbers, ((Card) obj).winningNumbers)
            && Arrays.equals(numbers, ((Card) obj).numbers);
    }

    public int score() {
        int count = (int) Arrays.stream(numbers)
                .filter(i -> Arrays.stream(winningNumbers).anyMatch(w -> w == i))
                .count();

        if(count == 0) return 0;
        return (int) Math.pow(2, count - 1);
    }
}
