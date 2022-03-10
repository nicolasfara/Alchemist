package it.unibo.alchemist.model.implementations.reactions

import it.unibo.alchemist.model.implementations.actions.steeringstrategies.Nearest
import it.unibo.alchemist.model.interfaces.Node
import it.unibo.alchemist.model.interfaces.TimeDistribution
import it.unibo.alchemist.model.interfaces.environments.Euclidean2DEnvironment

/**
 * Steering behavior using [Nearest] steering strategy (= the only action executed is the one with the nearest target).
 *
 * @param environment
 *          the environment inside which the pedestrian moves.
 * @param node
 *          the owner of this reaction.
 * @param timeDistribution
 *          the time distribution according to this the reaction executes.
 */
class PrioritySteering<T>(
    environment: Euclidean2DEnvironment<T>,
    node: Node<T>,
    timeDistribution: TimeDistribution<T>,
) : SteeringBehavior<T>(environment, node, timeDistribution, Nearest(environment, node))
