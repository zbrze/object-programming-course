package pl.agh.edu.dp.labirynth;

public class MazeGame {
    public Maze createMaze(MazeBuilder mazeBuilder){
        //zmiana na EnchantedMazeFactory
        MazeFactory enchantedMazeFactory = EnchantedMazeFactory.getInstance();
        if(mazeBuilder instanceof StandardBuilderMaze){
            ((StandardBuilderMaze) mazeBuilder).addMazeFactory(enchantedMazeFactory);
        }
        mazeBuilder.createRooms(2);

        MazeFactory mazeFactory = MazeFactory.getInstance();
        if(mazeBuilder instanceof StandardBuilderMaze){
            ((StandardBuilderMaze) mazeBuilder).addMazeFactory(mazeFactory);
        }
        mazeBuilder.createRooms(3);

        //zmiana na BombedMazeFactory
        MazeFactory bombedMazeFactory= BombedMazeFactory.getInstance();
        if(mazeBuilder instanceof StandardBuilderMaze){
            ((StandardBuilderMaze) mazeBuilder).addMazeFactory(bombedMazeFactory);
        }
        mazeBuilder.createRooms(2);
        //zmiana na MazeFactory
        if(mazeBuilder instanceof StandardBuilderMaze){
            ((StandardBuilderMaze) mazeBuilder).addMazeFactory(mazeFactory);
        }
        //Normal Door
        mazeBuilder.createDoor(1,4);
        mazeBuilder.createDoor(1,5);
        mazeBuilder.createDoor(4,6);

        //zmiana na EnchantedMazeFactory
        if(mazeBuilder instanceof StandardBuilderMaze){
            ((StandardBuilderMaze) mazeBuilder).addMazeFactory(enchantedMazeFactory);
        }
        //EnchantedDoor
        mazeBuilder.createDoor(0,2);
        mazeBuilder.createDoor(2,3);
        mazeBuilder.createDoor(3,1);
        return mazeBuilder.getMaze();
    }
}


