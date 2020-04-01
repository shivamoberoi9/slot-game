package org.app.game.betting.wintypes;

import org.app.game.betting.entity.RoundResult;

/**
 * Interface for all different chances of winning.
 * @author shivamoberoi
 *
 */
public interface WinOutcome
{
    /**
     * Operation for different types of winning probabilities. 
     * @param winningChances - chances of winning coins.
     * @param freeRoundChances - chances of winning free round
     * @param roundResult {@link RoundResult}
     * @param indicator
     * @return indicator- won or not.
     */
    boolean doOperation(double winningChances, double freeRoundChances, RoundResult roundResult, boolean indicator);
}
