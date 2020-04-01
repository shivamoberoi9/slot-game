package org.app.game.framework.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Winning Amount for each Game Round.
 * @author shivamoberoi
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WinningAmount
{
    private Long roundId;

    private int winningAmount;


    public WinningAmount()
    {

    }


    public WinningAmount(Long roundId, int winningAmount)
    {
        this.roundId = roundId;
        this.winningAmount = winningAmount;
    }


    public Long getRoundId()
    {
        return roundId;
    }


    public int getWinningAmount()
    {
        return winningAmount;
    }


    public static WinningAmountBuilder newBuilder()
    {
        return new WinningAmountBuilder();
    }

    public static class WinningAmountBuilder
    {
        private Long roundId;

        private int winningAmount;


        public WinningAmountBuilder setroundId(Long roundId)
        {
            this.roundId = roundId;
            return this;
        }


        public WinningAmountBuilder setWinningAmount(int winningAmount)
        {
            this.winningAmount = winningAmount;
            return this;
        }


        public WinningAmount createWinningAmountDTO()
        {
            return new WinningAmount(roundId, winningAmount);
        }


        @Override
        public boolean equals(Object o)
        {

            if (o == this)
                return true;
            if (!(o instanceof WinningAmount))
            {
                return false;
            }
            WinningAmount winningAmount = (WinningAmount) o;
            return winningAmount.roundId.equals(roundId);
        }


        @Override
        public int hashCode()
        {
            int result = 17;
            result = 31 * result + roundId.hashCode();
            return result;
        }

    }

}
