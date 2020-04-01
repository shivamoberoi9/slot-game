package org.app.game.betting.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *  Thrown when a Round encounters wrong Round Type or coins.  
 *  @author shivamoberoi
 * 
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RoundException extends Exception
{

    private static final long serialVersionUID = 1L;


    public RoundException(final String message)
    {
        super(message);
    }

}
