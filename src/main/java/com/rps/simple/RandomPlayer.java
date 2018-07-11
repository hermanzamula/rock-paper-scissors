package com.rps.simple;

import com.rps.RpsPlayer;
import lombok.*;

import java.util.Optional;
import java.util.Random;

@Data
@EqualsAndHashCode(of = {"name"})
@Builder
@AllArgsConstructor
public class RandomPlayer implements RpsPlayer<SimpleFigure> {
    private final String name;
    private final SimpleFigure initialFigure;
    private SimpleFigure lastFigure;

    @Override
    public String identity() {
        return name;
    }

    @Override
    public SimpleFigure initialFigure() {
        return initialFigure;
    }

    @Override
    public SimpleFigure currentFigure() {
        return Optional.ofNullable(lastFigure).orElse(initialFigure);
    }

    @Override
    public SimpleFigure nextFigure() {
        final SimpleFigure figure = SimpleFigure.values()[new Random().nextInt(SimpleFigure.values().length)];
        this.lastFigure = figure;
        return figure;
    }
}
