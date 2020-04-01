package org.app.game.betting.wintypes;

import org.app.game.betting.constants.RoundConstants;
import org.app.game.betting.entity.RoundResult;

/**
 * Implementation of Winning coins.
 * @author shivamoberoi
 *
 */
public class Coins implements WinOutcome
{
    /**
     * Operation for winning coins.
     */
    @Override
    public boolean doOperation(double winningChances, double freeRoundChances, RoundResult roundResult, boolean indicator)
    {
        if (winningChances <= RoundConstants.WINNING_COINS_CHANCE)
        {
            roundResult.setWinningAmount(roundResult.getWinningAmount() + 20);
            roundResult.setType(RoundConstants.WON);
            roundResult.setMessage("You have" + " " + roundResult.getType() + " " + roundResult.getWinningAmount() + " coins");
            indicator = true;
        }
        return indicator;
    }

}
