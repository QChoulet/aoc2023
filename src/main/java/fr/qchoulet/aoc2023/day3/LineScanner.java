package fr.qchoulet.aoc2023.day3;

@FunctionalInterface
interface LineScanner {
    int scanLine(String prevLine, String currentLine, String nextLine);
}
