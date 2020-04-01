package org.app.game.betting.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.app.game.betting.DummyDataTest;
import org.app.game.betting.dataaccessobject.RoundResultRepository;
import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.exception.RoundException;
import org.app.game.betting.service.GameRoundService;
import org.app.game.betting.service.GameRoundServiceImpl;
import org.app.game.betting.validation.RequestValidator;

public class GameRoundServiceTest extends DummyDataTest
{

    @Mock
    private RoundResultRepository roundResultRepository;

    @Mock
    private RequestValidator requestValidator;

    @InjectMocks
    private GameRoundServiceImpl gameRoundService;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(GameRoundService.class);
    }


    @Test
    public void playRoundTest() throws RoundException
    {
        RoundResult roundResult = getRoundResult();
        RoundRequest roundRequest = getNormalRoundRequest();
        when(roundResultRepository.save(any(RoundResult.class))).thenReturn(roundResult);
        when(requestValidator.validateRoundRequest(any(Boolean.class), any(String.class))).thenReturn(true);
        Assert.assertNotNull(gameRoundService.playRound(roundRequest));
        verify(roundResultRepository, times(1)).save(any(RoundResult.class));
    }


    @Test
    public void getWinningAmountTest() throws RoundException
    {
        RoundResult roundResult = getRoundResult();
        when(roundResultRepository.exists(1L)).thenReturn(true);
        when(roundResultRepository.findOne(any(Long.class))).thenReturn(roundResult);
        when(requestValidator.validateRoundRequest(any(Boolean.class), any(String.class))).thenReturn(true);
        Assert.assertNotNull(gameRoundService.getWinningAmount(1L));
        verify(roundResultRepository, times(1)).findOne(1L);
    }


    @Test
    public void playInvalidRoundTest() throws RoundException
    {
        RoundRequest roundRequest = getInvalidRoundTYpeRequest();
        gameRoundService.playRound(roundRequest);
    }

}
