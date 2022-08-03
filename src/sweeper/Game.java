package sweeper;

public class Game {

    Matrix bombMap;

    public Game(int cols, int rows) {
        Ranges.setSize(new Coord(cols, rows));
    }

    public void start(){
        bombMap = new Matrix(Box.BOMB);
    }
    public Box getBox(Coord coord){
        return Box.values()[(coord.x + coord.y)% Box.values().length];
    }
}
