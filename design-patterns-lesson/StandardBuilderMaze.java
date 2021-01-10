package pl.agh.edu.dp.labirynth;

public class StandardBuilderMaze implements MazeBuilder {
    private Maze currentMaze = new Maze();
    private MazeFactory mazeFactory ;

    @Override
    public boolean createDoor(int index1, int index2) {
        Room r1 = currentMaze.getRoomAtIndex(index1);
        Room r2 = currentMaze.getRoomAtIndex(index2);
        if(r1 == null || r2 == null) return false;
        Direction d1 = commonWall(r1, r2);
        if(doorBetweenRooms(r1, r2)) {
            System.out.println("drzwi istnieja");
            return false;
        }
        if(d1 == null) return false;
        MapSite door1 = mazeFactory.createDoor(r1,r2);
        r1.setSide(d1, door1);
        r2.setSide(Direction.oppositeDirection(d1), door1);
        currentMaze.RoomAtIndex(index1,r1);
        currentMaze.RoomAtIndex(index2,r2);
        return true;
    }

    @Override
    public boolean createRooms(int numberOfRooms) {
        int numOfRooms = currentMaze.getRoomNumbers();
        for (int i=0; i<numberOfRooms; i++){
            Room room = mazeFactory.createRoom(i+numOfRooms);
            createWalls(room);
            currentMaze.addRoom(room);
        }
        return true;
    }

    @Override
    public boolean createWalls(Room room) {
        room.setSide(Direction.North,mazeFactory.createWall());
        room.setSide(Direction.East,mazeFactory.createWall());
        room.setSide(Direction.South,mazeFactory.createWall());
        room.setSide(Direction.West,mazeFactory.createWall());
        return true;
    }


    @Override
    public Maze getMaze() {
        return this.currentMaze;
    }

    public void addMazeFactory(MazeFactory mazeFactory){
        this.mazeFactory = mazeFactory;
    }

    private boolean doorBetweenRooms(Room room1,Room room2){
        for(Direction d : Direction.values()){
            Direction d2 = Direction.oppositeDirection(d);
            if (room1.getSide(d).equals(room2.getSide(d2)) && room1.getSide(d) instanceof Door) return true;
        }
        return false;
    }


    private Direction commonWall(Room room1, Room room2)
    {
        for(Direction d : Direction.values()){
            Direction d2 = Direction.oppositeDirection(d);
            if(room1.getSide(d) instanceof Wall && room2.getSide(d2) instanceof Wall) return d;
        }
        return null;
    }
}
