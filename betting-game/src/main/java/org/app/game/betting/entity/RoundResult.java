package org.app.game.betting.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class for Response of the Round Played.
 * @author shivamoberoi
 *
 */
@Entity
@Table(name = "RoundResult")
public class RoundResult
{
    @Id
    @GeneratedValue
    private Long id;

    private int winningAmount;

    private String mesaage;

    private String type;


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public int getWinningAmount()
    {
        return winningAmount;
    }


    public void setWinningAmount(int winningAmount)
    {
        this.winningAmount = winningAmount;
    }


    public String getMesaage()
    {
        return mesaage;
    }


    public void setMessage(String mesaage)
    {
        this.mesaage = mesaage;
    }


    public String getType()
    {
        return type;
    }


    public void setType(String status)
    {
        this.type = status;
    }


    @Override
    public boolean equals(Object o)
    {

        if (o == this)
            return true;
        if (!(o instanceof RoundResult))
        {
            return false;
        }
        RoundResult roundResult = (RoundResult) o;
        return roundResult.id.equals(id);
    }


    @Override
    public int hashCode()
    {
        int result = 17;
        result = 31 * result + id.hashCode();
        return result;
    }

}
