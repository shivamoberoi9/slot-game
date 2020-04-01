package org.app.game.betting.integrationtest;

import static com.jayway.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.app.game.betting.entity.RoundRequest;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GameControllerIT
{
    @LocalServerPort
    private int port;

    private RoundRequest roundRequest;


    @Before
    public void setUp()
    {
        RestAssured.port = port;
    }


    @Test
    public void playNormalRoundTest()
    {
        roundRequest = new RoundRequest(10, "NORMAL-ROUND");
        Response response = given().contentType("application/json").body(roundRequest).when().post("/round/bet");
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_CREATED);
    }


    @Test
    public void playFreeRoundTest()
    {
        roundRequest = new RoundRequest(0, "FREE-ROUND");
        Response response = given().contentType("application/json").body(roundRequest).when().post("/round/bet");
        Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_CREATED);
    }


    @Test
    public void getWinningAmountTest()
    {
        roundRequest = new RoundRequest(10, "NORMAL-ROUND");
        Response roundResponse = given().contentType("application/json").body(roundRequest).when().post("/round/bet").andReturn();
        Assertions.assertThat(roundResponse.getStatusCode()).isEqualTo(HttpStatus.SC_CREATED);
        Response winningAmount = given().when().get("/round/winningAmount/2").thenReturn();
        Assertions.assertThat(winningAmount.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

    }

}
