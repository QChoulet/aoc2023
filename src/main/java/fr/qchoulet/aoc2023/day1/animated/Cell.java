package fr.qchoulet.aoc2023.day1.animated;

import fr.qchoulet.aoc2023.day1.Digit;
import processing.core.PApplet;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Cell {
    private final PApplet pApplet;
    private final int x;
    private final int y;
    private Map<Step, Integer> stepDurations;

    private Step currentStep = Step.INITIAL;
    private Line line;
    private int currentStepDuration;

    public Cell(PApplet pApplet, int x, int y, Line initialLine) {
        this.pApplet = pApplet;
        this.x = x;
        this.y = y;
        this.line = initialLine;

        stepDurations = new HashMap<>();
        for(Step step : Step.values()) {
            stepDurations.put(step, (int) pApplet.random(10, 20));
        }
    }

    public void update() {
        if(currentStep != Step.DONE && currentStepDuration == stepDurations.get(currentStep)) {
            currentStep = currentStep.next().orElse(currentStep);
            currentStepDuration = 1;
        } else {
            currentStepDuration++;
        }
    }

    public void draw() {
        String textToPrint = "";

        switch (currentStep) {
            case INITIAL -> textToPrint = line.text();
            case ALL_DIGITS -> {
                textToPrint = line.allDigits().stream()
                        .map(Digit::originalString)
                        .reduce(" ", (a, b) -> a +" "+ b);
            }
            case FIRST_AND_LAST -> {
                String first = line.allDigits().get(0).originalString();
                String last = line.allDigits().get(line.allDigits().size() - 1).originalString();
                textToPrint = first +" "+ last;
            }
            case RESULT, DONE -> {
                textToPrint = Integer.toString(line.result());
            }
        }

        pApplet.text(textToPrint, x, y);
    }

    public boolean isDone() {
        return currentStep == Step.DONE;
    }

    public void setLine(Line line) {
        this.line = line;
        this.currentStep = Step.INITIAL;
        this.currentStepDuration = 0;
    }

    private enum Step {
        INITIAL, ALL_DIGITS, FIRST_AND_LAST, RESULT, DONE;

        public Optional<Step> next() {
            if(this == DONE) {
                return Optional.empty();
            } else {
                return Optional.of(Step.values()[(this.ordinal() + 1)]);
            }
        }
    }
}
