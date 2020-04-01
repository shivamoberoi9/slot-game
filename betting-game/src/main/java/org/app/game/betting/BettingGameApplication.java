package org.app.game.betting;

import org.app.game.betting.constants.RoundConstants;
import org.app.game.betting.entity.RoundRequest;
import org.app.game.betting.entity.RoundResult;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * The Starting point of the game.
 * @author shivamoberoi
 *
 */
@SpringBootApplication
public class BettingGameApplication
{
    /**
     * Play Normal Round and play free round immediately after it if type is free-round .
     * @param  {@link RoundRequest}
     */
    public static void playRound(RoundRequest roundRequest)
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<RoundResult> roundresult = restTemplate.postForEntity("http://localhost:8080/round/bet", roundRequest, RoundResult.class);
        if (roundresult.getBody().getType().equals(RoundConstants.FREE_ROUND))
        {
            roundRequest.setCoins(0);
            roundRequest.setRoundType("FREE-ROUND");
            playRound(roundRequest);
        }
    }


    public static void main(String[] args)
    {
        SpringApplication.run(BettingGameApplication.class, args);
        // setting up the request for the normal round.
        RoundRequest roundRequest = new RoundRequest(10, "NORMAL-ROUND");
        playRound(roundRequest);
    }
}
