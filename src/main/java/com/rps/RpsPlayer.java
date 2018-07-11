package com.rps;

public interface RpsPlayer<F extends RpsFigure> {

    String identity();

    F initialFigure();

    /**
     * Contains current figure after calling {@link #nextFigure()}
     */
    F currentFigure();

    /**
     * Returns next bet of the player. Should set current figure
     * @see #currentFigure()
     */
    F nextFigure();

}
