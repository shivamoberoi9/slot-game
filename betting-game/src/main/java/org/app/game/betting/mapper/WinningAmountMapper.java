package org.app.game.betting.mapper;

import org.app.game.betting.entity.RoundResult;
import org.app.game.framework.entity.WinningAmount;

/**
 * Mapper for converting DO to DTO.
 * @author shivamoberoi
 *
 */
public class WinningAmountMapper
{
    /**
     * Converts RoundResult  to WinningAmount. 
     * @param  {@link RoundResult}
     * @return {@link WinningAmount}
     */
    public static WinningAmount makeWinningAmount(RoundResult roundResult)
    {
        WinningAmount.WinningAmountBuilder WinningAmountBuilder = WinningAmount.newBuilder().setroundId(roundResult.getId())
            .setWinningAmount(roundResult.getWinningAmount());
        return WinningAmountBuilder.createWinningAmountDTO();
    }
}
