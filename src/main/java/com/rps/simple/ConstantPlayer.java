package com.rps.simple;

import com.rps.RpsPlayer;
import lombok.*;

@Data
@EqualsAndHashCode(of = {"name"})
@Builder
@AllArgsConstructor
public class ConstantPlayer implements RpsPlayer<SimpleFigure> {
    private final String name;
    private final SimpleFigure figure;

    @Override
    public String identity() {
        return name;
    }

    @Override
    public SimpleFigure initialFigure() {
        return figure;
    }

    @Override
    public SimpleFigure currentFigure() {
        return figure;
    }

    @Override
    public SimpleFigure nextFigure() {
        return figure;
    }
}
