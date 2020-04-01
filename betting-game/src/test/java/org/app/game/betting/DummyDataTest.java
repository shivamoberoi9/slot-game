package org.app.game.betting;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.app.game.betting.constants.RoundConstants;
import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.entity.RoundResult;

@RunWith(MockitoJUnitRunner.class)
public abstract class DummyDataTest
{
    public RoundRequest getNormalRoundRequest()
    {
        RoundRequest roundRequest = new RoundRequest(10, "NORMAL-ROUND");
        return roundRequest;
    }


    public RoundRequest getFreeRoundRequest()
    {
        RoundRequest roundRequest = new RoundRequest(0, "FREE-ROUND");
        return roundRequest;
    }


    public RoundRequest getInvalidRoundTYpeRequest()
    {
        RoundRequest roundRequest = new RoundRequest(10, "NORL");
        return roundRequest;
    }
    
    public RoundRequest getLessCoinsRoundRequest()
    {
        RoundRequest roundRequest = new RoundRequest(8, "NORL");
        return roundRequest;
    }


    public RoundResult getRoundResult()
    {
        RoundResult roundResult = new RoundResult();
        roundResult.setId(1L);
        roundResult.setMessage("You have won");
        roundResult.setType(RoundConstants.WON);
        roundResult.setWinningAmount(20);
        return roundResult;
    }
}
