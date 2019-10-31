public class PatternBlock extends Pattern {
    private int sizeX = 4;
    private int sizeY = 4;
    boolean aliveCells [][] = new boolean[sizeY][sizeX];

    public PatternBlock() {

        aliveCells[1][1] = true;
        aliveCells[1][2] = true;
        aliveCells[2][1] = true;
        aliveCells[2][2] = true;

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

        return aliveCells[x][y];
    }
}
