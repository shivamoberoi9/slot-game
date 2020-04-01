package org.app.game.betting.wintypes;

import org.app.game.betting.constants.RoundConstants;
import org.app.game.betting.entity.RoundResult;

/**
 * Implementation of Winning a free round.
 * @author shivamoberoi
 *
 */
public class FreeRound implements WinOutcome
{
    /**
     * Operation for Winning free round.
     */
    @Override
    public boolean doOperation(double winningChances, double freeRoundChances, RoundResult roundResult, boolean indicator)
    {
        if (freeRoundChances <= RoundConstants.FREE_ROUND_CHANCE)
        {
            roundResult.setWinningAmount(roundResult.getWinningAmount());
            roundResult.setType(RoundConstants.FREE_ROUND);
            roundResult.setMessage("You have a" + " " + roundResult.getType() + " and " + " " + roundResult.getWinningAmount() + " " + "coins");
            indicator = true;
        }
        return indicator;
    }

}
