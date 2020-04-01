package org.app.game.betting.wintypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.exception.RoundException;
import org.app.game.betting.wintypes.CoinsAndFreeRound;
import org.app.game.betting.wintypes.WinOutcome;

public class CoinsAndFreeRoundTest
{

    private RoundResult roundResult;
    private WinOutcome coinsAndFreeRound;


    @Before
    public void setUp() throws Exception
    {
        roundResult = new RoundResult();
        coinsAndFreeRound = new CoinsAndFreeRound();
    }


    @Test
    public void WinCoinsAndFreeTest() throws RoundException
    {
        boolean result = coinsAndFreeRound.doOperation(0.2, 0.1, roundResult, false);
        Assert.assertTrue(result);
    }


    @Test
    public void NotWinFreeRoundTest() throws RoundException
    {
        boolean result = coinsAndFreeRound.doOperation(0.4, 0.4, roundResult, false);
        Assert.assertFalse(result);
    }
}
