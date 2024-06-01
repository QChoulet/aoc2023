package fr.qchoulet.aoc2023.day3;

import java.util.Iterator;
import java.util.stream.Stream;

public class Solver {
    public int solve_part1(Stream<String> input) {
        Iterator<String> it = input.iterator();

        if(!it.hasNext()) return 0;

        String curLine = null;
        String prevLine = null;
        String nextLine = it.next();
        int result = 0;

        do {
            prevLine = curLine;
            curLine = nextLine;
            nextLine = it.hasNext() ? it.next() : null;
            result += scanLine(prevLine, curLine, nextLine);
        } while(nextLine != null);

        return result;
    }

    private int scanLine(String prevLine, String curLine, String nextLine) {
        String currentNumber = "";
        boolean isPart = false;
        int sumPart = 0;

        for(int i = 0; i < curLine.length(); i++) {
            if(Character.isDigit(curLine.charAt(i))) {
                currentNumber += curLine.charAt(i);

                int neighbourStart = i - 1;
                int neighbourEnd = i + 1;

                isPart = isPart ||
                        findSymbol(curLine, neighbourStart, neighbourEnd) ||
                        (prevLine != null && findSymbol(prevLine, neighbourStart, neighbourEnd)) ||
                        (nextLine != null && findSymbol(nextLine, neighbourStart, neighbourEnd));

                if(isPart && (i == curLine.length() - 1)) {
                    sumPart += Integer.parseInt(currentNumber);
                }
            }
            else if(!currentNumber.isEmpty()) {
                if(isPart) {
                    sumPart += Integer.parseInt(currentNumber);
                }
                currentNumber = "";
                isPart = false;
            }
        }

        return sumPart;
    }

    private boolean findSymbol(String string, int start, int end) {
        start = Math.max(0, start);
        end = Math.min(string.length() - 1, end);

        for(int i = start; i <= end; i++) {
            if(!Character.isLetterOrDigit(string.charAt(i)) && string.charAt(i) != '.') {
                return true;
            }
        }

        return false;
    }
}
