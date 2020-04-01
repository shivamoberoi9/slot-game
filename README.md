
Make a game
You are tasked with creating a RESTful service using which players can play a simple game described
below.
The game should have the following rules:
• The player has an infinite amount of coins.
• The player bets 10 coins to play a normal game round.
• In any round (free or normal), the player has a 30% chance of winning back 20 coins.
• In any round (free or normal), the player also has a 10% chance of triggering a free round where
the player does not have to pay for bet. The free round works in the same way as a normal round except
it costs 0 coins. The free round should follow immediately after the normal round.
• The player can both win coins and free round at the same time.

### To Start

 This is a spring boot application. 
 Framework module is having all the resusable components. 
 Run mvn clean install in the slot-game(Parent module).
 
* In memory database(H2) for persisting round entity
 
*To run:  `mvn spring-boot:run` on the BettingGame module.
  
### Architecture Design:

MVC(Model, view and Controller)
1.	Controller:- For all incoming request.
2.	Mapper for DTO TO DO and DO to DTO.
3.	Service:-Business Logic to handle all the processing.
4.	DAO:-All for the database operation(save, delete).

### API:

1.	Play a Normal Round with 10 coins:- 

*curl -X POST --header "Content-Type: application/json" --header "Accept: /" -d "{"coins": 10, "roundType": "NORMAL-ROUND"}" "http://localhost:8080/round/bet"

2.	Get Winning Amount.

*curl -X GET --header "Accept: /" "http://localhost:8080/round/winningAmount/{roundId}
