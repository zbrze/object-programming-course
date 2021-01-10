package pl.agh.edu.dp.labirynth;

public class EnchantedWall extends Wall{
    public EnchantedWall(){
        super();
    }
    @Override
    public void Enter() {
        System.out.println("Enchanted wall in front of you");
    }
}
