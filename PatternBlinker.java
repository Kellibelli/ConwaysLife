public class PatternBlinker extends Pattern {
    private int sizeX = 5;
    private int sizeY = 5;
    boolean aliveCells [][] = new boolean[sizeY][sizeX];

    public PatternBlinker() {

        aliveCells[2][1] = true;
        aliveCells[2][2] = true;
        aliveCells[2][3] = true;
    }

    @Override
    public int getSizeX() {
        return sizeX;
    }

    @Override
    public int getSizeY() {
        return sizeY;
    }

    @Override
    public boolean getCell(int x, int y) {
        return aliveCells[y][x];
    }
}
