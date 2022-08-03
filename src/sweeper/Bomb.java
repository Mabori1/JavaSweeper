package sweeper;

class Bomb {

    private Matrix bombMap;
    private int totalBomb;

    public Bomb(int totalBomb) {
        this.totalBomb = totalBomb;
        fixBombCount();
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBomb; i++) {
            placeBomb();
        }

    }

    private void placeBomb() {
        while (true) {
            Coord coord = Ranges.getRandomCoord();
            if (bombMap.get(coord) == Box.BOMB)
                continue;
            bombMap.set(coord, Box.BOMB);
            incNumbersAroundBomb(coord);
            break;
        }
    }

    private void fixBombCount() {
        int maxBomb = Ranges.getSize().x * Ranges.getSize().y / 2;
        if (totalBomb > maxBomb)
            totalBomb = maxBomb;
    }

    private void incNumbersAroundBomb(Coord coord) {
        for (Coord around : Ranges.getCoordsAround(coord))
            if (Box.BOMB != bombMap.get(around))
                bombMap.set(around, bombMap.get(around).getNextNumberBox());
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }
}
