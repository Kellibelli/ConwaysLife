public class PatternAcorn extends Pattern{
    private int sizeY = 5;
    private int sizeX = 9;
    boolean aliveCells [][] = new boolean[sizeY][sizeX];

    public PatternAcorn() {

        aliveCells[3][1] = true;
        aliveCells[3][2] = true;
        aliveCells[1][2] = true;
        aliveCells[2][4] = true;
        aliveCells[3][5] = true;
        aliveCells[3][6] = true;
        aliveCells[3][7] = true;

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
