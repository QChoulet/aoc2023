package fr.qchoulet.aoc2023.day3;

public class PartScanner implements LineScanner {
    public int scanLine(String prevLine, String curLine, String nextLine) {
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
