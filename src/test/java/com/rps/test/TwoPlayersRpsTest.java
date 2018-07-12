package com.rps.test;

import com.rps.RpsEngine;
import com.rps.RpsPlayer;
import com.rps.RpsResult;
import com.rps.simple.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;

public class TwoPlayersRpsTest {

    @Test
    public void testTwoPlayersRpsEngine_ROCK_SCISSORS() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new TwoPlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> constantMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.SCISSORS).name("Random player 1").build()
        ), new SimpleRules());

        Assert.assertThat(constantMustWon.getWonPlayer(), instanceOf(ConstantPlayer.class));
        Assert.assertThat(constantMustWon.getWonPlayer().initialFigure(), is(SimpleFigure.ROCK));

        Assert.assertThat(constantMustWon.getGamesCount(), is(1L));
    }

    @Test
    public void testTwoPlayersRpsEngine_ROCK_PAPER() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new TwoPlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> constantMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.PAPER).name("Random player 1").build()
        ), new SimpleRules());

        Assert.assertThat(constantMustWon.getWonPlayer(), instanceOf(RandomPlayer.class));
        Assert.assertThat(constantMustWon.getWonPlayer().currentFigure(), is(SimpleFigure.PAPER));

        Assert.assertThat(constantMustWon.getGamesCount(), is(1L));
    }

    @Test
    public void testTwoPlayersRpsEngine_ROCK_ROCK() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new TwoPlayersRpsEngine();

        final RpsResult<RpsPlayer<SimpleFigure>> constantMustWon = engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 1").build()
        ), new SimpleRules());

        Assert.assertTrue(constantMustWon.getGamesCount() > 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoPlayersRpsEngine_exceptionWhenLessThan2Players() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new TwoPlayersRpsEngine();

        engine.play(Collections.singletonList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build()
        ), new SimpleRules());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTwoPlayersRpsEngine_exceptionWhenMoreThan2Players() {
        final RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> engine = new TwoPlayersRpsEngine();

        engine.play(Arrays.asList(
                ConstantPlayer.builder().figure(SimpleFigure.ROCK).name("Constant player").build(),
                ConstantPlayer.builder().figure(SimpleFigure.SCISSORS).name("Constant player 2").build(),
                RandomPlayer.builder().initialFigure(SimpleFigure.ROCK).name("Random player 2").build()
        ), new SimpleRules());
    }
}
