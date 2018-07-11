package com.rps;

import java.util.Map;
import java.util.Set;

import static java.util.Collections.singleton;

public interface RpsRules<FIGURE extends RpsFigure> {

    /**
     * @return transitions map that describes which FIGURE can beat another
     */
    Map<FIGURE, ? extends Set<FIGURE>> getRules();

    default boolean canBeat(FIGURE one, FIGURE other) {
        return this.canBeat(one, singleton(other));
    }

    default boolean canBeat(FIGURE one, Set<FIGURE> others) {
        return this.getRules().get(one).containsAll(others);
    }
}
