package services;

import models.Board;
import models.Ladder;
import models.Player;
import models.Snake;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BoardService {

    private  Board board;
    private  Queue<Player> players;
    private  List<Ladder> ladders;
    private  List<Snake> snakes;

    private Map<Integer,Integer> snakeMap = new HashMap<>();
    private Map<Integer,Integer> ladderMap = new HashMap<>();

    public BoardService(Board board, Queue<Player> players, List<Snake> snakes, List<Ladder> ladders) {
        this.board = board;
        this.players = players;
        this.ladders = ladders;
        this.snakes = snakes;
        for (Ladder ladder : ladders) {
            ladderMap.put(ladder.getStartPosition(), ladder.getEndPosition());
        }
        for (Snake snake : snakes) {
            ladderMap.put(snake.getHead(), snake.getTail());
        }
    }

    public void setPosition(Player player, int diceValue) {
        int initialPosition = player.getPosition();
        int finalPosition = initialPosition+ diceValue;
        while (ladderMap.containsKey(finalPosition) || snakeMap.containsKey(finalPosition)){
            if(ladderMap.containsKey(finalPosition)){
                finalPosition = ladderMap.get(finalPosition);
            }else{
                finalPosition = snakeMap.get(finalPosition);
            }
        }
        if(finalPosition <= 100){
            player.setPosition(finalPosition);
        };

    }
}
