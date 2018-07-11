package com.rps;

import lombok.Getter;

@Getter
public class RpsResult<PLAYER extends RpsPlayer<? extends RpsFigure>> {

    private final PLAYER wonPlayer;
    private final long gamesCount;

    public RpsResult(PLAYER wonPlayer, long gamesCount) {
        this.wonPlayer = wonPlayer;
        this.gamesCount = gamesCount;
    }
}
