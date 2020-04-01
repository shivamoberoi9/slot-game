package org.app.game.betting.wintypes;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.app.game.betting.DummyDataTest;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.exception.RoundException;
import org.app.game.betting.wintypes.Coins;
import org.app.game.betting.wintypes.WinOutcome;

public class CoinsTest extends DummyDataTest
{

    private RoundResult roundResult;
    private WinOutcome coins;


    @Before
    public void setUp() throws Exception
    {
        roundResult = new RoundResult();
        coins = new Coins();
    }


    @Test
    public void WinCoinsTest() throws RoundException
    {
        boolean result = coins.doOperation(0.2, 0.4, roundResult, false);
        Assert.assertTrue(result);
    }


    @Test
    public void NotWinCoinsTest() throws RoundException
    {
        boolean result = coins.doOperation(0.4, 0.4, roundResult, false);
        Assert.assertFalse(result);
    }
}
