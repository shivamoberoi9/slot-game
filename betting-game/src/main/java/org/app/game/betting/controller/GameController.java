package org.app.game.betting.controller;

import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.exception.RoundException;
import org.app.game.betting.mapper.WinningAmountMapper;
import org.app.game.betting.service.GameRoundService;
import org.app.game.framework.entity.WinningAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller Class for all the rounds of the game to be played.
 * @author shivamoberoi
 *
 */
@RestController
@RequestMapping("/round")
public class GameController
{

    private final GameRoundService gameRoundService;


    @Autowired
    public GameController(final GameRoundService gameRoundService)
    {
        this.gameRoundService = gameRoundService;
    }


    /**
     * API method to place the bet for the normal round.
     * @param {@link RoundRequest}
     * @return {@link RoundResult}
     * @throws {@link RoundException}
     */
    @PostMapping("bet")
    @ResponseStatus(HttpStatus.CREATED)
    public RoundResult placeBet(@RequestBody RoundRequest roundRequest) throws RoundException
    {
        return gameRoundService.playRound(roundRequest);
    }


    /**
     * API method to get the winning amount for a round
     * @param roundId
     * @return {@link WinningAmount}
     * @throws {@link NoRoundFoundException} 
     */
    @GetMapping("winningAmount/{roundId}")
    public WinningAmount getWinningAmount(@PathVariable long roundId) throws RoundException
    {
        return WinningAmountMapper.makeWinningAmount(gameRoundService.getWinningAmount(roundId));
    }
}
