package org.app.game.betting.constants;

/**
 * Constants for the Game Round.
 * @author shivamoberoi
 *
 */
public final class RoundConstants
{
    /**
     * The Normal round Format to play normal round.
     */
    public static final String NORMAL_ROUND = "NORMAL-ROUND";
    /**
     * The Free round Format to play normal round.
     */
    public static final String FREE_ROUND = "FREE-ROUND";
    /**
     * Type if won the bet.
     */
    public static final String WON = "WON";
    /**
     * Probability of winning coins.
     */
    public static final Double WINNING_COINS_CHANCE = 0.3;
    /**
     * Probability of winning a free round.
     */
    public static final Double FREE_ROUND_CHANCE = 0.1;
    /**
     * The coins required to play a normal round.
     */
    public static final int REQUIRED_COINS = 10;
    /**
     * No of coins returned if won.
     */
    public static final int WIN_COINS = 20;
    /**
     * Type if lost the bet.
     */
    public static final String LOST = "LOST";

    public static final String ROUND_TYPE_MESSAGE = "Enter Correct Round Type";

    public static final String REQUIRED_COINS_MESSAGE = "You need minimum 10 coins";
}
