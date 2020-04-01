package org.app.game.betting.constants;

import org.app.game.betting.wintypes.Coins;
import org.app.game.betting.wintypes.CoinsAndFreeRound;
import org.app.game.betting.wintypes.FreeRound;
import org.app.game.betting.wintypes.WinOutcome;

/**
 * ENUM for all types of Winning outcomes
 * @author shivamoberoi
 *
 */
public enum WinTypes
{
    COINSANDFREEROUND(new CoinsAndFreeRound()), FREEROUND(new FreeRound()), COINS(new Coins());

    private WinOutcome winType;


    private WinTypes(WinOutcome winType)
    {
        this.winType = winType;
    }


    /**
     * Get the win type.
     * @return
     */
    public WinOutcome getWinType()
    {
        return winType;
    }
}
