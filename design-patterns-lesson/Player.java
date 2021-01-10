package pl.agh.edu.dp.labirynth;

public class Player {
    private String playerName;
    private int hp;
    Room currentRoom;

    public Player(String name, Room startRoom) {
        playerName = name;
        currentRoom = startRoom;
        hp = 100;
    }

    public int getHp(){
        return this.hp;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room){
        this.currentRoom = room;
    }

    public boolean isAlive(){
        return (this.hp > 0);
    }

    public void changeHp(int points){
        this.hp += points;
    }

    @Override
    public String toString() {
        return "Player  " +
                " " + playerName + '\'' +
                ", hp=" + hp ;
    }
}