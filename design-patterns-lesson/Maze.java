package pl.agh.edu.dp.labirynth;

import java.util.Iterator;
import java.util.Vector;

public class Maze {
    private Vector<Room> rooms;

    public Maze() {
        this.rooms = new Vector<Room>();
    }

    public void addRoom(Room room){
        rooms.add(room);
    }

    public void setRooms(Vector<Room> rooms) {
        this.rooms = rooms;
    }

    public int getRoomNumbers()
    {
        return rooms.size();
    }

    public Room getRoomAtIndex(int index){
        if(index<getRoomNumbers()){
            return rooms.elementAt(index);
        }
        else return null;
    }

    public void RoomAtIndex(int index,Room room){
        rooms.remove(index);
        rooms.insertElementAt(room,index);
    }

}
