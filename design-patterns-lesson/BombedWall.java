package pl.agh.edu.dp.labirynth;

public class BombedWall extends Wall {
    BombedWall(){
        super();
    }

    @Override
    public void Enter() {
        System.out.println("You've entered the BombedWall");
    }
}
