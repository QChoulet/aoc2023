package fr.qchoulet.aoc2023.day3;

import java.util.Iterator;
import java.util.stream.Stream;

public class Solver {
    public int solve_part1(Stream<String> input) {
        Iterator<String> it = input.iterator();
        return scanFile(it, new PartScanner());
    }

    public int solve_part2(Stream<String> input) {
         Iterator<String> it = input.iterator();
         return scanFile(it, new GearScanner());
    }

    private int scanFile(Iterator<String> it, LineScanner scanner) {
        if(!it.hasNext()) return 0;

        String curLine = null;
        String prevLine = null;
        String nextLine = it.next();
        int result = 0;

        do {
            prevLine = curLine;
            curLine = nextLine;
            nextLine = it.hasNext() ? it.next() : null;
            result += scanner.scanLine(prevLine, curLine, nextLine);
        } while(nextLine != null);

        return result;
    }
}
