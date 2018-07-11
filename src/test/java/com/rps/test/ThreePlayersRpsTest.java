package com.rps.test;

import com.rps.RpsEngine;
import com.rps.RpsPlayer;
import com.rps.RpsResult;
import com.rps.simple.*;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class ThreePlayersRpsTest {

    @Test
    public void testThreePlayersRpsEngine_ROCK_SCISSORS_SCISSORS() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> constantMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.SCISSORS).name("Random player 1").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.SCISSORS).name("Random player 2").build()
        ), new SimpleRules());

        Assert.assertThat(constantMustWon.getWonPlayer(), instanceOf(ConstantPlayer.class));
        Assert.assertThat(constantMustWon.getWonPlayer().initialFigure(), is(SimpleFigure.ROCK));

        Assert.assertThat(constantMustWon.getGamesCount(), is(1L));
    }

    @Test
    public void testThreePlayersRpsEngine_SCISSORS_ROCK_ROCK() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> randomMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.SCISSORS).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 1").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 2").build()
        ), new SimpleRules());

        Assert.assertThat(randomMustWon.getWonPlayer(), instanceOf(RandomPlayer.class));
        Assert.assertThat(randomMustWon.getWonPlayer().initialFigure(), is(SimpleFigure.ROCK));

        Assert.assertThat(randomMustWon.getGamesCount(), CoreMatchers.not(1L));
    }

    @Test
    public void testThreePlayersRpsEngine_PAPER_ROCK_ROCK() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> randomMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.PAPER).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 1").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 2").build()
        ), new SimpleRules());

        Assert.assertThat(randomMustWon.getWonPlayer(), instanceOf(ConstantPlayer.class));
        Assert.assertThat(randomMustWon.getWonPlayer().initialFigure(), is(SimpleFigure.PAPER));

        Assert.assertThat(randomMustWon.getGamesCount(), CoreMatchers.is(1L));
    }

    @Test
    public void testThreePlayersRpsEngine_PAPER_PAPER_PAPER() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> randomMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.PAPER).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.PAPER).name("Random player 1").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.PAPER).name("Random player 2").build()
        ), new SimpleRules());

        Assert.assertTrue(randomMustWon.getGamesCount() > 1);
    }

    @Test
    public void testThreePlayersRpsEngine_SCISSORS_SCISSORS_SCISSORS() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> randomMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.SCISSORS).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.SCISSORS).name("Random player 1").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.SCISSORS).name("Random player 2").build()
        ), new SimpleRules());

        Assert.assertTrue(randomMustWon.getGamesCount() > 1);
    }

    @Test
    public void testThreePlayersRpsEngine_ROCK_ROCK_ROCK() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> randomMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 1").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 2").build()
        ), new SimpleRules());

        Assert.assertTrue(randomMustWon.getGamesCount() > 1);
    }

    @Test
    public void testThreePlayersRpsEngine_ROCK_PAPER_SCISSORS() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> randomMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.PAPER).name("Random player 1").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.SCISSORS).name("Random player 2").build()
        ), new SimpleRules());

        Assert.assertTrue(randomMustWon.getGamesCount() > 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThreePlayersRpsEngine_exceptionWhenLessThan3Players() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 2").build()
        ), new SimpleRules());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThreePlayersRpsEngine_exceptionWhenMoreThan3Players() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new ThreePlayersRpsEngine();

        engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                ConstantPlayer.builder().figure(SimpleFigure.SCISSORS).name("Constant player 2").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 2").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 1").build()
        ), new SimpleRules());
    }

}
