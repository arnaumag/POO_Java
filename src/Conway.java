public class Conway {
    private boolean[][] cells;

    public Conway(int nbCells) {
        cells = new boolean[nbCells][nbCells];
    }

    public Conway() {
        this(10);
    }

    public boolean[][] getCells() {
        return cells;
    }

    public void setCells(boolean[][] cells) {
        this.cells = cells;
    }

    private int countNeighbours(int i, int j) {
        int nbNeighbours = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            if (k < 0 || k >= cells.length) {
                continue;
            }
            for (int l = j - 1; l <= j + 1; l++) {
                if (l < 0 || l >= cells.length) {
                    continue;
                }
                if (k == i && l == j) {
                    continue;
                }
                if (cells[k][l]) {
                    nbNeighbours++;
                }
            }
        }
        return nbNeighbours;
    }

    public void nextGeneration() {
        boolean[][] newCells = new boolean[cells.length][cells.length];
        for (int i = 0; i < cells.length; i++) {
            boolean[] row = cells[i];
            for (int j = 0; j < row.length; j++) {
                int nbNeighbours = countNeighbours(i, j);
                if (nbNeighbours == 3) {
                    newCells[i][j] = true;
                } else if (nbNeighbours == 2) {
                    newCells[i][j] = cells[i][j];
                } else {
                    newCells[i][j] = false;
                }
            }
        }
        setCells(newCells);
    }

    public void reInit() {
        for (int i = 0; i < cells.length; i++) {
            boolean[] row = cells[i];
            for (int j = 0; j < row.length; j++) {
                cells[i][j] = false;
            }
        }
        cells[1][1] = true;
        cells[1][2] = true;
        cells[2][1] = true;
        cells[2][3] = true;
        cells[4][4] = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] row : cells) {
            for (boolean cell : row) {
                sb.append(cell ? "X" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
