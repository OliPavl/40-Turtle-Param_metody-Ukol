package net.sevecek.turtle;

import net.sevecek.turtle.engine.*;

public class HlavniProgram {

    Turtle zofka;

    public void main(String[] args) {


        zofka = new Turtle();

        zofka.setLocation(500.0, 400.0);
        nakresliSnehulaka();

        zofka.setLocation(1000.0, 400.0);
        nakresliMasinku();

        zofka.setLocation(200.0, 400.0);
        nakresliZmrzku();

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

    public void nakresliObdelnik(double stranaA, double stranaB) {
        for (int i = 0; i < 2; i++) {
            zofka.move(stranaA);
            zofka.turnLeft(90);
            zofka.move(stranaB);
            zofka.turnLeft(90);
        }

    }

    public double vypocitejDelkuTretiStrany(double delkaStrany, double uhelMeziRameny) {
        double tretiStrana;
        tretiStrana = Math.abs((delkaStrany
                * Math.sin((uhelMeziRameny * Math.PI / 180.0) / 2.0))
                * 2.0);
        return tretiStrana;

    }

    public void nakresliRovnoramennyTrojuhelnik(double velikostStrany, double uhelMeziRameny) {
        double vnitrniUhelMeziZakladnouARamenem = (180 - uhelMeziRameny) / 2;

        zofka.move(velikostStrany);
        zofka.turnLeft(180 - vnitrniUhelMeziZakladnouARamenem);
        double delkaZakladny = vypocitejDelkuTretiStrany(velikostStrany, uhelMeziRameny);
        zofka.move(delkaZakladny);
        zofka.turnLeft(180 - vnitrniUhelMeziZakladnouARamenem);
        zofka.move(velikostStrany);
        zofka.turnLeft(90);


    }

    public void nakresliMasinku() {
        nakresliKruh(60);

        nakresliObdelnik(180, 120);
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(120);
        zofka.turnRight(90);
        zofka.penDown();

        nakresliObdelnik(90, 180);
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(30);
        zofka.turnLeft(90);
        zofka.move(30);
        zofka.turnLeft(180);
        zofka.penDown();

        nakresliKruh(25);
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(75);
        zofka.turnRight(90);
        zofka.penDown();

        nakresliKruh(25);
        zofka.penUp();
        zofka.turnLeft(90);
        zofka.move(75);
        zofka.penDown();
        zofka.turnRight(90);

        nakresliRovnoramennyTrojuhelnik(90, 90);

    }

    public void nakresliKornout(double velikostStrany, double uhelMeziRameny) {
        double vnitrniUhelMeziZakladnouARamenem = (180 - uhelMeziRameny) / 2;

        zofka.turnRight(uhelMeziRameny / 2);
        zofka.move(velikostStrany);
        zofka.turnLeft(180 - vnitrniUhelMeziZakladnouARamenem);
        double delkaZakladny = vypocitejDelkuTretiStrany(velikostStrany, uhelMeziRameny);
        zofka.move(delkaZakladny);
        zofka.turnLeft(180 - vnitrniUhelMeziZakladnouARamenem);
        zofka.move(velikostStrany);
        zofka.turnLeft(180 - uhelMeziRameny);

        zofka.penUp();
        zofka.move(velikostStrany + 15);
        zofka.turnLeft(uhelMeziRameny / 2);
        zofka.penDown();

    }

    public void nakresliZmrzku() {
        nakresliKornout(120, 45);
        nakresliKruh(50);
    }

}
