package pl.agh.edu.dp.labirynth;

public interface MazeBuilder {

    boolean createDoor(int index1, int index2);

    /**
     * @return True if door has been successfully created
     */

    boolean createRooms(int numberOfRooms);

    /**
     *
     * @return True if room has been successfully created
     */

    boolean createWalls(Room room);

    /**
     *
     * @return True if wall has been successfully created
     */

    Maze getMaze();
    /**
     * @return current version of maze
     */


}
