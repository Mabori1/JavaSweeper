package sweeper;

class Flag {
    private Matrix flagMap;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        countOfClosedBoxes = Ranges.getSize().x * Ranges.getSize().y;
    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
        countOfClosedBoxes--;
    }

    public void setFlagedToBox(Coord coord) {
        flagMap.set(coord,Box.FLAGED);
    }

    protected void toggleFlagedToBox(Coord coord) {
        switch (flagMap.get(coord)){
            case FLAGED : setClosedToBox(coord); return;
            case CLOSED : setFlagedToBox(coord);return;
        }
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord,Box.CLOSED);
    }

    int getCountOfClosedBoxes() {
        return countOfClosedBoxes;
    }
}
