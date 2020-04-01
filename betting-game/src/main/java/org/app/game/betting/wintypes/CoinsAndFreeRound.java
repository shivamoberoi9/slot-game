package org.app.game.betting.wintypes;

import org.app.game.betting.constants.RoundConstants;
import org.app.game.betting.entity.RoundResult;

/**
 * Implementation of Winning chances and a free round.
 * @author shivamoberoi
 *
 */
public class CoinsAndFreeRound implements WinOutcome
{
    /**
     * Operation for winning coins and free round.
     */
    @Override
    public boolean doOperation(double winningChances, double freeRoundChances, RoundResult roundResult, boolean indicator)
    {
        if (winningChances <= RoundConstants.WINNING_COINS_CHANCE && freeRoundChances <= RoundConstants.FREE_ROUND_CHANCE)
        {
            roundResult.setWinningAmount(roundResult.getWinningAmount() + RoundConstants.WIN_COINS);
            roundResult.setType(RoundConstants.FREE_ROUND);
            roundResult.setMessage("You have " + RoundConstants.WON +" "+ roundResult.getWinningAmount() + " coins and  a " + RoundConstants.FREE_ROUND);
            indicator = true;
        }
        return indicator;
    }
}
