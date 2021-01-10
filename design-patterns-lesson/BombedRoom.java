package pl.agh.edu.dp.labirynth;

public class BombedRoom extends Room {

    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        System.out.println("You've entered bombed room number:  " + this.getRoomNumber());
    }
}
