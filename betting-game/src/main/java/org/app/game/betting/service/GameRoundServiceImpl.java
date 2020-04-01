package org.app.game.betting.service;

import org.app.game.betting.constants.RoundConstants;
import org.app.game.betting.constants.WinTypes;
import org.app.game.betting.dataaccessobject.RoundResultRepository;
import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.entity.RoundResult;
import org.app.game.betting.exception.RoundException;
import org.app.game.betting.validation.RequestValidator;
import org.app.game.framework.generate.RandomGenerator;
import org.springframework.stereotype.Service;

/**
 * Implementation of GameRound Service.
 * @author shivamoberoi
 *
 */
@Service
public class GameRoundServiceImpl implements GameRoundService
{

    private final RoundResultRepository roundResultRepository;

    private final RequestValidator requestValidator;


    public GameRoundServiceImpl(final RoundResultRepository roundResultRepository, final RequestValidator requestValidator)
    {
        this.roundResultRepository = roundResultRepository;
        this.requestValidator = requestValidator;
    }


    @Override
    public RoundResult playRound(final RoundRequest roundRequest) throws RoundException
    {
        validateRoundRequest(roundRequest);
        RoundResult roundResult = getRoundResult();
        return roundResultRepository.save(roundResult);
    }


    @Override
    public RoundResult getWinningAmount(final long roundId) throws RoundException
    {
        requestValidator.validateRoundRequest(roundResultRepository.exists(roundId), "No roundId with " + roundId + " found");
        return roundResultRepository.findOne(roundId);
    }


    /**
     * Validates if a request is having a valid data.
     * @param  {@link RoundRequest}
     * @throws {@link RoundException}
     */
    private void validateRoundRequest(final RoundRequest roundRequest) throws RoundException
    {
        final String roundType = roundRequest.getRoundType();
        //check if valid round type
        requestValidator.validateRoundRequest((roundType.equals(RoundConstants.NORMAL_ROUND)) || (roundType.equals(RoundConstants.FREE_ROUND)), RoundConstants.ROUND_TYPE_MESSAGE);
        //check if required coins for each round.
        requestValidator.validateRoundRequest(
            (roundRequest.getRoundType().equals(RoundConstants.NORMAL_ROUND)) && (roundRequest.getCoins() == RoundConstants.REQUIRED_COINS)
                || roundType.equals(RoundConstants.FREE_ROUND),
            RoundConstants.REQUIRED_COINS_MESSAGE);

    }


    /**
     * Getting Round Result on the basis of the generated random numbers.
     * @param  {@link RoundResult}
     * @return {@link RoundResult}
     */
    private RoundResult getRoundResult()
    {
        RoundResult roundResult = new RoundResult();
        // initially setting roundResult to Lost
        roundResult.setWinningAmount(roundResult.getWinningAmount());
        roundResult.setType(RoundConstants.LOST);
        roundResult.setMessage("You have" + " " + roundResult.getType() + " " + "the bet");
        Double winningChances = RandomGenerator.getNumbers();
        Double freeRoundChances = RandomGenerator.getNumbers();
        boolean indicator = false;
        WinTypes winTypes[] = WinTypes.values();
        for (WinTypes winType : winTypes)
        {
            // check if any win probabilities matched.
            if (winType.getWinType().doOperation(winningChances, freeRoundChances, roundResult, indicator))
            {
                break;
            }
        }
        return roundResult;
    }
}
