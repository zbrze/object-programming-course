package pl.agh.edu.dp.labirynth;

public class EnchantedDoor extends Door {
    public EnchantedDoor(Room room1, Room room2){
        super(room1,room2);
    }
    public void Enter(){
        System.out.println("You've opened enchanted door");
    }
}


