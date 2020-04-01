package org.app.game.betting.validation;

import org.app.game.betting.exception.RoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * Validator class to validate input.Mean to throw {@link RoundException} with specific expression and message
 * @author shivamoberoi
 *
 */
@Component
public class RequestValidator
{

    public boolean validateRoundRequest(boolean expression, String message) throws RoundException
    {
        Assert.notNull(expression, "expression");
        Assert.notNull(message, "message");
        if (!expression)
        {
            throw new RoundException(message);
        }
        return true;

    }
}
