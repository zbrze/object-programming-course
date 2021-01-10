package pl.agh.edu.dp.labirynth;

public enum Direction {
    North, South, East, West;

    public static Direction oppositeDirection(Direction direction){
        switch (direction){
            case North:
                return Direction.South;
            case South:
                return Direction.North;
            case West:
                return Direction.East;
            case East:
                return Direction.West;
        }
        return null;
    }
    public static Direction wsadToDirection(String wsad){
        switch (wsad){
            case "w":
                return Direction.North;
            case "s":
                return Direction.South;
            case "a":
                return Direction.West;
            case "d":
                return Direction.East;

        }
        return null;
    }
}