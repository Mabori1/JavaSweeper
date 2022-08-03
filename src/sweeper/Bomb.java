package sweeper;

class Bomb {

    private Matrix bombMap;
    private int totalBomb;

    public Bomb(int totalBomb) {
        this.totalBomb = totalBomb;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBomb; i++) {
            placeBomb();
        }

    }

    private void placeBomb() {
        Coord coord = Ranges.getRandomCoord();
        bombMap.set(coord, Box.BOMB);
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }
}
