package pl.agh.edu.dp.labirynth;

public class EnchantedMazeFactory extends MazeFactory {
    private static EnchantedMazeFactory instance;
    public static EnchantedMazeFactory getInstance() {
        if(instance == null) instance = new EnchantedMazeFactory();
        return instance;
    }
    @Override
    public Door createDoor(Room r1, Room r2) {
        return new EnchantedDoor(r1, r2);
    }
    @Override
    public Wall createWall(){
        return new EnchantedWall();
    }
    @Override
    public Room createRoom(int index){
        return new EnchantedRoom(index);
    }
}

