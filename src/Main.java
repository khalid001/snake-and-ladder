import models.Ladder;
import models.Player;
import models.Snake;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("input.txt");
        List<String> lines = Files.readAllLines(filePath);
        List<Snake> snakes = new ArrayList<>();
        List<Ladder> ladders = new ArrayList<>();
        Queue<Player> players = new LinkedList<>();
        int no_of_snakes = Integer.parseInt(lines.getFirst());
        int i =1;
        while(0<no_of_snakes) {
            String[] head_and_tail = lines.get(i).split("\\s+");
            int head = Integer.parseInt(head_and_tail[0]) ;
            int tail = Integer.parseInt(head_and_tail[1]) ;
            Snake s = new Snake(head, tail);
            snakes.add(s);
            no_of_snakes-=1;
            i+=1;
        }
        int no_of_ladders = Integer.parseInt(lines.get(i));
        i+=1;
        while(0 < no_of_ladders) {
            String[] head_and_tail = lines.get(i).split("\\s+");
            int start = Integer.parseInt(head_and_tail[0]) ;
            int end = Integer.parseInt(head_and_tail[1]) ;
            Ladder l = new Ladder(start, end);
            ladders.add(l);
            no_of_ladders-=1;
            i+=1;
        }
        int no_of_players = Integer.parseInt(lines.get(i));
        i+=1;
        while(0 < no_of_players) {
            String name = lines.get(i);
            Player p = new Player(name, 0);
            players.add(p);
            no_of_players-=1;
            i+=1;
        }
        Game game = new Game(players,ladders,snakes,100,6);
        game.launch();
    }
}