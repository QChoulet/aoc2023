package fr.qchoulet.aoc2023.day1.animated;

import fr.qchoulet.aoc2023.day1.Digit;
import fr.qchoulet.aoc2023.day1.LineDecoder;
import fr.qchoulet.aoc2023.utils.InputLoader;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class AnimatedSolver extends PApplet {
    private final int width = 1600;
    private final int height = 900;
    private final int cols = 5;
    private final int rows = 30;

    private List<Line> lines;
    private final List<Cell> cells = new ArrayList<>(rows * cols);

    private int nextLine;


    public void settings(){
        size(width, height);

        // Let's decode all lines first and just run the animation after
        LineDecoder decoder = new LineDecoder();
        lines = InputLoader.readLines("1")
                .map(lineString -> {
                    List<Digit> digits = decoder.findAllDigits(lineString, true);
                    int result = digits.get(0).value() * 10 + digits.get(digits.size() - 1).value();
                    return new Line(lineString, result, digits);
                })
                .toList();
        nextLine = rows * cols;

        createCells();
    }

    public void draw(){
        frameRate(60);
        background(50);
        textAlign(CENTER);

        for(Cell cell : cells) {
            if(cell.isDone() && nextLine < lines.size()) {
                cell.setLine(lines.get(nextLine));
                nextLine++;
            }
            cell.update();
            cell.draw();
        }
    }

    private void createCells() {
        int colWidth = width / cols;
        int rowHeight = height / rows;

        for(int i = 0; i < cols; i++) {
            for(int j = 0; j < rows; j++) {
                int cellX = i * colWidth + colWidth / 2;
                int cellY = j * rowHeight + rowHeight / 2;
                cells.add(new Cell(this, cellX, cellY, lines.get(i * rows + j)));
            }
        }
    }
}
