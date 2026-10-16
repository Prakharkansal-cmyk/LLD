import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentIndex;

    public Game(int size, List<Player> players) {
        this.board = new Board(size);
        this.players = players;
        this.currentIndex = 0;
    }

    public void play() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            board.showBoard();
            Player current = players.get(currentIndex);
            System.out.print(current.getName() + " (" + current.getSymbol() + "), row aur col daalo: ");
            // Poori line padho, taaki extra number agli chaal mein na chala jaaye
            String[] parts = sc.nextLine().trim().split("\\s+");
            if (parts.length != 2) {
                System.out.println("Sirf 2 number daalo: row col. Dobara try karo.");
                continue;
            }

            int row, col;
            try {
                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Sirf numbers daalo. Dobara try karo.");
                continue;
            }

            if (!board.placeSymbol(row, col, current.getSymbol())) {
                System.out.println("Invalid move! Dobara try karo.");
                continue;
            }

            if (hasWon(row, col, current.getSymbol())) {
                board.showBoard();
                System.out.println(current.getName() + " jeet gaya!");
                return;
            }

            if (board.isFull()) {
                board.showBoard();
                System.out.println("Game Draw!");
                return;
            }

            currentIndex = (currentIndex + 1) % players.size();
        }
    }

    private boolean hasWon(int row, int col, Symbol symbol) {
        int n = board.getSize();
        boolean rowWin = true, colWin = true, diagWin = true, antiDiagWin = true;

        for (int i = 0; i < n; i++) {
            if (board.getCell(row, i).getSymbol() != symbol) rowWin = false;
            if (board.getCell(i, col).getSymbol() != symbol) colWin = false;
            if (board.getCell(i, i).getSymbol() != symbol) diagWin = false;
            if (board.getCell(i, n - 1 - i).getSymbol() != symbol) antiDiagWin = false;
        }
        return rowWin || colWin || diagWin || antiDiagWin;
    }
}
