package fr.qchoulet.aoc2023.day3;

import java.util.ArrayList;
import java.util.List;

public class GearScanner implements LineScanner {
    public int scanLine(String prevLine, String currentLine, String nextLine) {
        int result = 0;
        if(currentLine.isEmpty()) return result;

        for(int i = 0; i < currentLine.length(); i++) {
            if(currentLine.charAt(i) == '*') {
                List<Integer> prevParts = findParts(prevLine, i);
                List<Integer> curParts = findParts(currentLine, i);
                List<Integer> nextParts = findParts(nextLine, i);

                curParts.addAll(prevParts);
                curParts.addAll(nextParts);
                result += ratio(curParts);
            }
        }

        return result;
    }

    private List<Integer> findParts(String line, int gearIndex) {
        if(line == null || line.isEmpty()) return new ArrayList<>();
        List<Integer> parts = new ArrayList<>(2); // can't have more than 2 pieces on one line

        int i = Math.max(0, gearIndex - 1);
        while(i <= gearIndex + 1 && i < line.length()){
            if(Character.isDigit(line.charAt(i))) {
                int cursor, start = i, end = i;
                // search left
                cursor = i - 1;
                while(cursor >= 0 && Character.isDigit(line.charAt(cursor))) {
                    start = cursor;
                    cursor--;
                }
                // search right
                cursor = i + 1;
                while(cursor < line.length() && Character.isDigit(line.charAt(cursor))) {
                    end = cursor;
                    cursor++;
                }
                parts.add(Integer.parseInt(line.substring(start, end + 1)));
                i = end + 1;
            } else {
                i++;
            }
        }

        return parts;
    }

    private int ratio(List<Integer> parts) {
        if(parts.size() != 2) return 0;

        int ratio = 1;
        for(int part : parts) {
            ratio *= part;
        }

        return ratio;
    }
}
