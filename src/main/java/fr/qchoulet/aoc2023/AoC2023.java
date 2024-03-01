package fr.qchoulet.aoc2023;

import fr.qchoulet.aoc2023.day1.Solver;
import processing.core.PApplet;

public class AoC2023 {
    public static void main(String... args) {
        Solver solver = new Solver();
        System.out.printf("Part 1 : %s%n", solver.solve_part1());
        System.out.printf("Part 2 : %s%n", solver.solve_part2());
    }

//    public void settings(){
//        size(200, 200);
//    }
//
//    public void draw(){
//        background(0);
//        ellipse(mouseX, mouseY, 20, 20);
//    }
//
//    public static void main(String... args){
//        PApplet.main("fr.qchoulet.aoc2023.AoC2023");
//    }
}
