package pl.agh.edu.dp.labirynth;

public class EnchantedRoom extends Room{
    public EnchantedRoom(int number) {
        super(number);
    }
    public void Enter(){
        System.out.println("You've entered the enchanted room number:  " + this.getRoomNumber());
    }
}
