package com.rps.simple;

import com.rps.RpsRules;

import java.util.*;

import static com.rps.simple.SimpleFigure.*;

/**
 * These rules represents common approach:
 * Rock beats Scissors
 * Scissors beats Paper
 * Paper beats Rock
 */
public class SimpleRules implements RpsRules<SimpleFigure> {

    private final Map<SimpleFigure, EnumSet<SimpleFigure>> simpleRules = new HashMap<SimpleFigure, EnumSet<SimpleFigure>>(){{
        put(ROCK, EnumSet.of(SCISSORS));
        put(SCISSORS, EnumSet.of(PAPER));
        put(PAPER, EnumSet.of(ROCK));
    }};

    @Override
    public Map<SimpleFigure, EnumSet<SimpleFigure>> getRules() {
        return simpleRules;
    }
}
