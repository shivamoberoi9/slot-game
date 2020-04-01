package org.app.game.betting.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.app.game.betting.DummyDataTest;
import org.app.game.betting.constants.RoundConstants;
import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.exception.RoundException;

public class RequestValidatorTest extends DummyDataTest
{

    private RequestValidator requestValidator;
    private RoundRequest roundRequest;


    @Before
    public void setUp() throws Exception
    {
        requestValidator = new RequestValidator();
    }


    @Test
    public void NormalRoundTypeOKTest() throws RoundException
    {
        roundRequest = getNormalRoundRequest();
        boolean result = requestValidator.validateRoundRequest(roundRequest.getRoundType().equals(RoundConstants.NORMAL_ROUND), "");
        Assert.assertTrue(result);
    }


    @Test
    public void FreeRoundTypeOKTest() throws RoundException
    {
        roundRequest = getFreeRoundRequest();
        boolean result = requestValidator.validateRoundRequest(roundRequest.getRoundType().equals(RoundConstants.FREE_ROUND), "");
        Assert.assertTrue(result);
    }


    @Test(expected = RoundException.class)
    public void InvalidRoundTypeTest() throws RoundException
    {
        roundRequest = getInvalidRoundTYpeRequest();
        requestValidator.validateRoundRequest(roundRequest.getRoundType().equals(RoundConstants.NORMAL_ROUND), "");
    }


    @Test(expected = RoundException.class)
    public void LessCoinsTest() throws RoundException
    {
        roundRequest = getLessCoinsRoundRequest();
        requestValidator.validateRoundRequest(roundRequest.getCoins() == RoundConstants.REQUIRED_COINS, "");
    }
}
