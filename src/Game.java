import models.*;
import services.BoardService;
import services.DiceService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    Queue<Player> players ;
    Queue<Player> winners = new LinkedList<>();
    List<Ladder> ladders ;

    List<Snake> snakes ;
    Board board ;
    BoardService boardService;
    DiceService diceService;

    public Game(Queue<Player> players, List<Ladder> ladders, List<Snake> snakes, int boardSize, int noOfDiceFaces) {
        this.players = players;
        this.ladders = ladders;
        this.snakes = snakes;
        this.board = new Board(boardSize);
        this.boardService = new BoardService(board, players, snakes, ladders);
        this.diceService = new DiceService(new Dice(noOfDiceFaces));
    }

    public void launch() {

        while(players.size()>0){
            Player playerHavingTurn = players.remove();
            int diceValue = DiceService.rollDice();
            int initialPosition = playerHavingTurn.getPosition();
            boardService.setPosition(playerHavingTurn, diceValue);
            int finalPosition = playerHavingTurn.getPosition();
            System.out.println(playerHavingTurn.getName()+" rolled a "+ diceValue +" and moved from "+initialPosition +" to "+finalPosition );
            if(finalPosition<100){
                players.add(playerHavingTurn);
            }else{
                winners.add(playerHavingTurn);
                System.out.println(playerHavingTurn.getName()+" wins the game");
            }
        }
    }
}
