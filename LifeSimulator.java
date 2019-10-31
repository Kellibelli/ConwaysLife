public class LifeSimulator {
    boolean[][] grid;
    boolean newGrid [][];
    int sizeX;
    int sizeY;

    public LifeSimulator(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        grid = new boolean[sizeY][sizeX];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                grid[j][i] = false;
            }

        }



    }

    public int getSizeX() {

        return sizeX;
    }

    public int getSizeY() {

        return sizeY;
    }

    public boolean getCell(int y, int x) {

        return grid[y][x];

    }

    public void insertPattern(Pattern pattern, int startX, int startY) {
        for (int i = 0; i < pattern.getSizeX(); i++) {
            for (int j = 0; j < pattern.getSizeY(); j++) {
                grid[j + startY][i + startX] = pattern.getCell(i, j);
            }
        }
    }

    public void update() {
        newGrid = new boolean[sizeY][sizeX];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                newGrid[j][i] = false;
            }

        }

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                int neighbors = 0;
                //Above
                if (i > 0 && j > 0) {
                    if (grid[j - 1][i - 1]) {
                        neighbors++;
                    }
                }
                if (j > 0) {
                    if (grid[j - 1][i]) {
                        neighbors++;
                    }
                }
                if (j > 0 && i + 1 < sizeX) {
                    if (grid[j - 1][i + 1]) {
                        neighbors++;
                    }
                }

                // Below
                if (j + 1 < sizeY && i + 1 < sizeX) {
                    if (grid[j + 1][i + 1]) {
                        neighbors++;
                    }
                }
                if (j + 1 < sizeY) {
                    if (grid[j + 1][i]) {
                        neighbors++;
                    }
                }
                if (j + 1 < sizeY && i > 0) {
                    if (grid[j + 1][i - 1]) {
                        neighbors++;
                    }
                }

                // Left
                if (i > 0) {
                    if (grid[j][i - 1]) {
                        neighbors++;
                    }
                }

                // Right
                if (i + 1 < sizeX) {
                    if (grid[j][i + 1]) {
                        neighbors++;
                    }
                }

                // Dead
                if (neighbors == 3 && !grid[j][i]) {
                    // set cell to alive
                    newGrid[j][i] = true;
                }

                // Alive
                if (neighbors < 2 && grid[j][i]) {
                    // set cell dead
                    newGrid[j][i] = false;
                }
                if (neighbors < 3 && grid[j][i]) {
                    // set cell dead
                    newGrid[j][i] = false;

                }
                if ((neighbors == 2 || neighbors == 3) && grid[j][i]) {
                    // cell stays alive
                    newGrid[j][i] = true;
                }
            }
        }
        this.grid = newGrid;
    }
}
