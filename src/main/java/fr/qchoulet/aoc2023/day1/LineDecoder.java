package fr.qchoulet.aoc2023.day1;

import java.util.ArrayList;
import java.util.List;

public class LineDecoder {
    private final List<String> spelledDigits = List.of("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

    public int decodeLine(String line, boolean includeSpelled) {
        List<Digit> allDigits = allDigits(line, includeSpelled);
        if(allDigits.isEmpty()){
            return 0;
        }
        int firstDigit = allDigits.get(0).value();
        int lastDigit = allDigits.get(allDigits.size() - 1).value();
        return firstDigit * 10 + lastDigit;
    }

    public List<Digit> allDigits(String line, boolean includeSpelled) {
        List<Digit> result = new ArrayList<>();
        String currentWord = "";

        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            // We have a single char digit, add to the list and reset currentWord because a spelled number can't contain a digit
            if(isCharADigit(c)) {
                result.add(new Digit(i, Character.getNumericValue(c)));
                currentWord = "";
            }
            // This whole part could probably be simplified a lot by using line.indexOf() for each element in spelledDigits
            // (still would have to take into account the case where a spelled digit is included twice though)
            // But I liked the challenge of trying to solve the problem while looping through the line only once
            else if(includeSpelled) {
                currentWord += c;
                // Let's see if our current word matches a spelled digit
                int wordIndex = spelledDigits.indexOf(currentWord);
                if(wordIndex >= 0) {
                    result.add(new Digit(i - (currentWord.length() - 1), wordIndex + 1));
                    // We can keep only the last letter of currentWord because there is no more overlapping between all spelled digits
                    currentWord = currentWord.substring(currentWord.length() - 1);
                } else {
                    // If not a perfect match we remove the first letter of currentWord
                    // until it's empty or there is candidates
                    List<Digit> candidates = findCandidates(currentWord, spelledDigits);
                    while(!currentWord.isEmpty() && candidates.isEmpty()) {
                        currentWord = currentWord.substring(1);
                        candidates = findCandidates(currentWord, spelledDigits);
                    }
                }
            }
        }
        return result;
    }

    private boolean isCharADigit(char c) {
        return c >= '0' && c <= '9';
    }

    private List<Digit> findCandidates(String word, List<String> allCandidates) {
        return allCandidates.stream()
                .filter(s -> s.startsWith(word))
                .map(s -> new Digit(0, allCandidates.indexOf(s) + 1))
                .toList();
    }
}
