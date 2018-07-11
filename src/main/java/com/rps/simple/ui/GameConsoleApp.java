package com.rps.simple.ui;

import com.rps.RpsPlayer;
import com.rps.RpsResult;
import com.rps.simple.*;

import java.util.Arrays;
import java.util.Random;

public class GameConsoleApp {

    public static void main(String[] args) {
        final ThreePlayersRpsEngine rpsEngine = new ThreePlayersRpsEngine();

        System.out.println("############### Rock-Paper-Scissors example with 3 players #################");
        System.out.println("#### 1 player is constantly using ROCK, other - random, 100 iterations #####\n\n");

        for (int i = 0; i < 100; i++) {
            final ConstantPlayer constantPlayer = ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant Player").build();
            final RandomPlayer randomPlayer1 = RandomPlayer.builder().initialFigure(rnd()).name("Random Player 1").build();
            final RandomPlayer randomPlayer2 = RandomPlayer.builder().initialFigure(rnd()).name("Random Player 2").build();

            final RpsResult<RpsPlayer<SimpleFigure>> result = rpsEngine.play(Arrays.asList(constantPlayer, randomPlayer1, randomPlayer2), new SimpleRules());

            System.out.printf("Iteration %d: Player won: %s, played rounds: %d\n", i + 1, result.getWonPlayer(), result.getGamesCount());
        }

    }

    private static SimpleFigure rnd() {
        return SimpleFigure.values()[new Random().nextInt(SimpleFigure.values().length)];
    }
}
