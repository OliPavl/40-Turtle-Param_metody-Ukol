package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

public class HlavniProgram {

    Turtle zofka;

    public void main(String[] args) {


        zofka = new Turtle();

        zofka.setLocation(500.0, 400.0);
        nakresliSnehulaka();

    }

    public void nakresliKruh(double radius) {
        for (int i = 0; i < 30; i++) {
            double pi = (3.14);
            zofka.move((2 * pi * radius) / 30);
            zofka.turnLeft(360 / 30);
        }
    }

    public void zvedniPacku(double delka) {
        zofka.penUp();
        zofka.move(delka);
        zofka.turnLeft(90);
        zofka.move(15);
        zofka.turnRight(90);
        zofka.penDown();
    }

    public void nakresliLevouRucicku() {
        zofka.penUp();
        for (int i = 0; i < 2; i++) {
            zofka.turnLeft(90);
            zofka.move(105);
        }
    }

    public void nakresliPravouRucicku() {
        zofka.penUp();
        zofka.turnRight(90);
        zofka.move(158);
        zofka.penDown();
        zofka.turnLeft(90);
        nakresliKruh(20);

    }

    public void nakresliSnehulaka() {
        nakresliKruh(75);
        zvedniPacku(135);
        nakresliKruh(60);
        zvedniPacku(100);
        nakresliKruh(40);
        nakresliLevouRucicku();
        zofka.turnLeft(180);
        zofka.penDown();
        nakresliKruh(20);
        nakresliPravouRucicku();
    }
}
