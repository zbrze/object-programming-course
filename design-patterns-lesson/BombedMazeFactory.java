package pl.agh.edu.dp.labirynth;

public class BombedMazeFactory extends MazeFactory{
    private static BombedMazeFactory instance;
    public static BombedMazeFactory getInstance() {
        if(instance == null) instance = new BombedMazeFactory();
        return instance;
    }

    @Override
    public Room createRoom(int index) {
        return new BombedRoom(index);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }
}
