package pl.agh.edu.dp.labirynth;

import java.util.EnumMap;
import java.util.Map;

public class Room extends MapSite
{
    private int roomNumber;
    private Map<Direction, MapSite> sides;


    public Room(int number){
        this.sides = new EnumMap<>(Direction.class);
        this.roomNumber = number;
    }

    public MapSite getSide(Direction direction){
        return this.sides.get(direction);
    }

    public void setSide(Direction direction, MapSite ms){
        if(this.sides.containsKey(direction)){
            this.sides.remove(direction);
        }
        this.sides.put(direction,ms);
    }

    public int getRoomNumber(){
        return this.roomNumber;
    }

    @Override
    public void Enter(){
        System.out.println("You've entered normal room number:  " + this.roomNumber);
    }
}
