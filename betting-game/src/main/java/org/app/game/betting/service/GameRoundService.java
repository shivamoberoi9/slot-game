package org.app.game.betting.service;

import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.exception.RoundException;

/**
 * Service for different operations of round.
 * @author shivamoberoi
 *
 */
public interface GameRoundService
{
    /**
     * Method to play normalRound/free round.
     * @param {@link RoundRequest}
     * @return {@link RoundResult}
     * @throws {@link RoundException} 
     */
    RoundResult playRound(RoundRequest roundrequest) throws RoundException;


    /**
     * Method to get the winning amount.
     * @param roundId
     * @return {@ link RoundResult}
     * @throws {@link RoundException}
     */
    RoundResult getWinningAmount(long roundId) throws RoundException;

}
