public class PatternGlider extends Pattern {
    private int sizeX = 5;
    private int sizeY = 5;
    boolean aliveCells [][] = new boolean[sizeY][sizeX];

    public PatternGlider() {

        aliveCells[3][1] = true;
        aliveCells[3][2] = true;
        aliveCells[3][3] = true;
        aliveCells[2][3] = true;
        aliveCells[1][2] = true;
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
