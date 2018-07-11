package com.rps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

public interface RpsEngine<PLAYER extends RpsPlayer<FIGURE>, FIGURE extends RpsFigure> {

    /**
     * Executes initial bets with given {@code figureRules}
     *
     * @param initialPlayersBets the first players bet
     * @param figureRules        contains set of transitions/rules
     * @return Player which won the game and count of the games
     */
    default RpsResult<PLAYER> play(List<PLAYER> initialPlayersBets, RpsRules<FIGURE> figureRules) {
        if (initialPlayersBets.size() < 2) {
            throw new IllegalArgumentException("Players count should be more than 1");
        }

        final HashSet<PLAYER> beatenPlayers = new HashSet<>();
        final HashSet<PLAYER> currentPlayers = new HashSet<>(initialPlayersBets);

        Function<PLAYER, FIGURE> figureMethod = PLAYER::initialFigure;

        int games = 0;

        while (currentPlayers.size() > 1) {
            games++;
            final ArrayList<PLAYER> players = new ArrayList<>(currentPlayers);

            for (int i = 0; i < currentPlayers.size() - 1; i++) {
                for (int j = i + 1; j < currentPlayers.size(); j++) {

                    final FIGURE iFigure = figureMethod.apply(players.get(i));
                    final FIGURE jFigure = figureMethod.apply(players.get(j));

                    if (figureRules.canBeat(iFigure, jFigure)) {
                        beatenPlayers.add(players.get(j));
                    } else if (!iFigure.equals(jFigure)) {
                        beatenPlayers.add(players.get(i));
                    }
                }
            }

            figureMethod = PLAYER::nextFigure;

            if (beatenPlayers.size() != currentPlayers.size()) {
                currentPlayers.removeAll(beatenPlayers); // difference
            }

            beatenPlayers.clear();
        }

        final PLAYER player = currentPlayers.stream().findFirst().orElseThrow(IllegalStateException::new);

        return new RpsResult<>(player, games);
    }

}
