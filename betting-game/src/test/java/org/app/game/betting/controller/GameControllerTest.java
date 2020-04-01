package org.app.game.betting.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.app.game.betting.DummyDataTest;
import org.app.game.betting.controller.GameController;
import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.service.GameRoundService;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GameControllerTest extends DummyDataTest
{
    private static final ObjectMapper mapper = new ObjectMapper();

    private MockMvc mvc;

    @Mock
    private GameRoundService gameRoundService;

    @InjectMocks
    private GameController gameController;


    @BeforeClass
    public static void setUp()
    {
        MockitoAnnotations.initMocks(GameController.class);
    }


    @Before
    public void init()
    {
        mvc = MockMvcBuilders.standaloneSetup(gameController).dispatchOptions(true).build();
    }


    @Test
    public void playRoundTest() throws Exception
    {
        RoundResult roundResult = getRoundResult();
        RoundRequest roundRequest = getNormalRoundRequest();
        doReturn(roundResult).when(gameRoundService).playRound(any(RoundRequest.class));
        gameController.placeBet(roundRequest);
        String jsonInString = mapper.writeValueAsString(roundRequest);
        MvcResult result = mvc
            .perform(post("/round/bet").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(jsonInString))
            .andExpect(MockMvcResultMatchers.status().isCreated()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertTrue(responseBody.contains("20"));
    }
    
    @Test
    public void getWinningAmountTest() throws Exception
    {
        RoundResult roundResult = getRoundResult();
        doReturn(roundResult).when(gameRoundService).getWinningAmount(1L);
        gameController.getWinningAmount(1L);
        MvcResult result = mvc.perform(get("/round/winningAmount/{roundId}", 1L))
            .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        final String responseBody = result.getResponse().getContentAsString();
        Assert.assertNotNull(responseBody);
    }
    
    

}
