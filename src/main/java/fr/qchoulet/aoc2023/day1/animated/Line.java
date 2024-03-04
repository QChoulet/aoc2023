package fr.qchoulet.aoc2023.day1.animated;

import fr.qchoulet.aoc2023.day1.Digit;

import java.util.List;

public record Line(
        String text,
        int result,
        List<Digit> allDigits
) {}
