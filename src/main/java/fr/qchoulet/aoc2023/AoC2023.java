package fr.qchoulet.aoc2023;

import processing.core.PApplet;

public class AoC2023 extends PApplet {
    public void settings(){
        size(200, 200);
    }

    public void draw(){
        background(0);
        ellipse(mouseX, mouseY, 20, 20);
    }

    public static void main(String... args){
        PApplet.main("fr.qchoulet.aoc2023.AoC2023");
    }
}
