package org.app.game.betting.entity;

/**
 * Round Request for each Game having coins and Round type.
 * @author shivamoberoi
 *
 */
public class RoundRequest
{
    public RoundRequest()
    {

    }


    public RoundRequest(int coins, String roundType)
    {
        this.coins = coins;
        this.roundType = roundType;
    }

    private int coins;

    private String roundType;


    public int getCoins()
    {
        return coins;
    }


    public void setCoins(int coins)
    {
        this.coins = coins;
    }


    public String getRoundType()
    {
        return roundType;
    }


    public void setRoundType(String roundType)
    {
        this.roundType = roundType;
    }
}
