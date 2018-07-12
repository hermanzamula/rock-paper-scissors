package com.rps.simple;

import com.rps.RpsEngine;
import com.rps.RpsPlayer;
import com.rps.RpsResult;
import com.rps.RpsRules;

import java.util.List;

public class TwoPlayersRpsEngine implements RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> {

    @Override
    public RpsResult<RpsPlayer<SimpleFigure>> play(List<RpsPlayer<SimpleFigure>> initialPlayersBets, RpsRules<SimpleFigure> figureRules) {
        if (initialPlayersBets.size() != 2) {
            throw new IllegalArgumentException("TwoPlayersRpsEngine accepts only 2 players");
        }

        return RpsEngine.super.play(initialPlayersBets, figureRules);
    }
}
