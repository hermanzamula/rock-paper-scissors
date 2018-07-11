package com.rps.simple;

import com.rps.RpsEngine;
import com.rps.RpsPlayer;
import com.rps.RpsResult;
import com.rps.RpsRules;

import java.util.List;

/**
 * 3-players restricted implementation
 */
public class ThreePlayersRpsEngine implements RpsEngine<RpsPlayer<SimpleFigure>, SimpleFigure> {

    @Override
    public RpsResult<RpsPlayer<SimpleFigure>> play(List<RpsPlayer<SimpleFigure>> initialPlayersBets, RpsRules<SimpleFigure> figureRules) {
        if (initialPlayersBets.size() != 3) {
            throw new IllegalArgumentException("ThreePlayersRpsEngine accepts only 3 players");
        }

        return RpsEngine.super.play(initialPlayersBets, figureRules);
    }

}
