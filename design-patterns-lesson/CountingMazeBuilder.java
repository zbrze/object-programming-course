package pl.agh.edu.dp.labirynth;

public class CountingMazeBuilder extends StandardBuilderMaze{
    private int roomNumber;
    private int doorNumber;
    private int wallNumber;

    public CountingMazeBuilder(){
        roomNumber = 0;
        doorNumber = 0;
        wallNumber = 0;
    }

    @Override
    public boolean createRooms(int number){
        if(super.createRooms(number)){
            roomNumber += number;
            return true;
        }
        return false;
    }

    @Override
    public boolean createWalls(Room r1){
        if (super.createWalls(r1)) {
            wallNumber += 4;
            return true;
        }
        return false;
    }

    @Override
    public boolean createDoor(int index1, int index2) {
        if (super.createDoor(index1, index2)) {
            doorNumber += 1;
            wallNumber -= 1;
            return true;
        }
        return false;
    }

    public void getCounts(){
        System.out.println("Rooms: " + roomNumber);
        System.out.println("Walls: " + wallNumber);
        System.out.println("Doors: " + doorNumber);
    }
}