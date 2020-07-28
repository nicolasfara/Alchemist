/*
 * Copyright (C) 2010-2019, Danilo Pianini and contributors listed in the main project's alchemist/build.gradle file.
 *
 * This file is part of Alchemist, and is distributed under the terms of the
 * GNU General Public License, with a linking exception,
 * as described in the file LICENSE in the Alchemist distribution's top directory.
 */
package it.unibo.alchemist.test;

import java.awt.Component;

import it.unibo.alchemist.boundary.wormhole.interfaces.ViewType;
import org.junit.jupiter.api.Test;

import it.unibo.alchemist.boundary.wormhole.implementation.Wormhole2D;
import it.unibo.alchemist.model.implementations.environments.Continuous2DEnvironment;
import it.unibo.alchemist.model.implementations.positions.Euclidean2DPosition;
import it.unibo.alchemist.model.interfaces.Environment;

import static it.unibo.alchemist.boundary.wormhole.implementation.PointAdapter.from;

/**
 * Test for bugs in {@link Wormhole2D}.
 */
public class TestWormhole2D {

    /**
     * Ensure that no exception is thrown when a zero-sized environment is
     * requested.
     */
    @Test
    public void testZeroSizeEnvironment() {
        final Environment<Object, Euclidean2DPosition> env = new Continuous2DEnvironment<>();
        final Wormhole2D<Euclidean2DPosition> worm = new Wormhole2D<>(
                env,
                new ViewType() {
                    @Override
                    public double getWidth() {
                        return 0;
                    }

                    @Override
                    public double getHeight() {
                        return 0;
                    }
                },
                viewType -> from(viewType.getWidth() / 2.0, viewType.getHeight() / 2.0)
        );
        worm.center();
    }
}
