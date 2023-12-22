package services;

import models.Dice;

import java.util.Random;

public class DiceService {
    private static Dice dice;
    static Random random = new Random();
    public DiceService(Dice dice) {
        this.dice = dice;
    }

    public static int rollDice(){
        return random.nextInt(1,dice.getFaces());
    }
}
