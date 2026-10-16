public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = new Cell(i, j);
    }

    public void showBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol s = grid[i][j].getSymbol();
                System.out.print(s == null ? " - " : " " + s + " ");
            }
            System.out.println();
        }
    }

    public boolean placeSymbol(int row, int col, Symbol symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size) return false;
        if (!grid[row][col].isEmpty()) return false;
        grid[row][col].setSymbol(symbol);
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j].isEmpty()) return false;
        return true;
    }

    public Cell getCell(int row, int col) { return grid[row][col]; }
    public int getSize() { return size; }
}
