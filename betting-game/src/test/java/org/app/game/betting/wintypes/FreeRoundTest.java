package org.app.game.betting.wintypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.exception.RoundException;
import org.app.game.betting.wintypes.FreeRound;
import org.app.game.betting.wintypes.WinOutcome;

public class FreeRoundTest
{

    private RoundResult roundResult;
    private WinOutcome freeRound;


    @Before
    public void setUp() throws Exception
    {
        roundResult = new RoundResult();
        freeRound = new FreeRound();
    }


    @Test
    public void WinFreeTest() throws RoundException
    {
        boolean result = freeRound.doOperation(0.4, 0.1, roundResult, false);
        Assert.assertTrue(result);
    }


    @Test
    public void NotWinFreeRoundTest() throws RoundException
    {
        boolean result = freeRound.doOperation(0.4, 0.4, roundResult, false);
        Assert.assertFalse(result);
    }
}
