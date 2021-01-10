package pl.agh.edu.dp.labirynth;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private MazeGame mazeGame;
    private MazeBuilder mazeBuilder;
    private Maze maze;
    private Player player;
    public Game(){
        mazeGame = new MazeGame();
        mazeBuilder = new StandardBuilderMaze();
        maze = mazeGame.createMaze(mazeBuilder);
        MazeBuilder countingMazeBuilder = new CountingMazeBuilder();
        mazeGame.createMaze(countingMazeBuilder);
        ((CountingMazeBuilder) countingMazeBuilder).getCounts();
    }

    public void runGame(){
        try{
            int it = 0; //maksymalna liczba ruchów
            System.out.println("Choose player name");
            BufferedReader gameReader = new BufferedReader(new InputStreamReader(System.in));
            String name = gameReader.readLine();
            player = new Player(name, maze.getRoomAtIndex(0));
            while(player.isAlive()){
                System.out.println("Move (W, S, A, D) or quit game (Q) ");
                String move = gameReader.readLine();
                if(move.toLowerCase().equals("q")){
                    System.out.println("End game");
                    break;
                }
                Direction dir = Direction.wsadToDirection(move.toLowerCase());
                movePlayer(dir);
                System.out.println(player.toString());

                if(it == 50 ) break;
                it+=1;
            }
            System.out.println("You died!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void movePlayer(Direction direction){
        MapSite side = player.getCurrentRoom().getSide(direction);
        if(side instanceof Wall){
            if(side instanceof BombedWall){
                ((BombedWall) side).Enter();
                player.changeHp(-10);
                System.out.println("-10hp");
            } else if(side instanceof EnchantedWall){
                ((EnchantedWall) side).Enter();
            } else {
                side.Enter();
            }
        } else if (side instanceof Door){
            Room room;
            if(side instanceof EnchantedDoor){
                ((EnchantedDoor) side).Enter();
            } else {
                side.Enter();
            }

            if(player.getCurrentRoom().equals(((Door) side).getRoom1())) room = ((Door) side).getRoom2();
            else room = ((Door) side).getRoom1();

            int index = room.getRoomNumber();
            if(room instanceof BombedRoom){
                ((BombedRoom)room).Enter();
                if (index % 7 == 0) {
                    player.changeHp(-30);
                    System.out.println("-30hp");
                }
                else if(index % 3 == 0){
                    player.changeHp(-10);
                    System.out.println("-10hp");
                }
                else if(index %2 == 0){
                    player.changeHp(-5);
                    System.out.println("-30hp");
                }
                player.setCurrentRoom(room);

            } else if(room instanceof EnchantedRoom){
                ((EnchantedRoom) room).Enter();
                if (index % 10 == 0){
                    player.changeHp(100);
                    System.out.println("+100hp");
                }
                else if (index % 7 == 0){
                    player.changeHp(-50);
                    System.out.println("-50hp");
                }
                else if(index % 5 == 0){
                    player.changeHp(-20);
                    System.out.println("-20hp");
                }
                else if(index % 3 == 0){
                    player.changeHp(10);
                    System.out.println("+10hp");
                }
                player.setCurrentRoom(room);

            } else{
                room.Enter();
                player.setCurrentRoom(room);
            }

        }
    }
}

