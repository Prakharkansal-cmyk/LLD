# Tic-Tac-Toe

A console Tic-Tac-Toe game for two players on an N×N board.

## Requirements

1. The board is N×N (3×3 by default).
2. There are 2 players, with symbols **X** and **O**.
3. Players take turns.
4. On each turn, a player picks an empty cell and places their symbol there.
5. A player who fills a full row, column or diagonal wins.
6. If the board fills up with no winner, the game is a draw.
7. A move outside the board or on a filled cell is invalid, and the same player tries again.

## Design

### Entities

| Class | Responsibility |
|-------|----------------|
| `Game` | Runs the game loop, rotates turns, decides win or draw |
| `Board` | Holds the N×N grid, places symbols, checks if full |
| `Cell` | One square of the grid: its position and symbol |
| `Player` | A player's name and symbol |
| `Symbol` | Enum: `X`, `O` |

### Relationships

```
Game
 ├── List<Player> players   (1 → many)
 ├── Board board            (1 → 1)
 │     └── Cell[][] grid    (1 → many)
 │           └── Cell: row, col, Symbol symbol
 └── int currentIndex       (whose turn it is)

Player
 └── Symbol symbol          (1 → 1)
```

### Key decisions

- **`List<Player>` for players:** a list keeps the turn order, and `(currentIndex + 1) % players.size()` works for any number of players.
- **`Cell[][]` for the board:** any cell can be reached in O(1) with `grid[row][col]`.
- **No setters for fixed data:** a cell's `row`/`col` and a player's `name`/`symbol` never change, so they only have getters.
- **`Board.placeSymbol()` returns `boolean`:** the board only says whether the move was valid. `Game` decides to give the player another try.
- **O(N) win check:** after each move, only the row, the column and the two diagonals of that move are checked, not the whole board.
- **Win is checked before draw:** the last move can fill the board and win at the same time.
- **Line-based input:** the whole line is read and must contain exactly 2 numbers. With `nextInt()`, an extra number on one line would carry over into the next move.

## Run

Open this folder in IntelliJ and run `Main`, or:

```bash
javac -d out src/*.java
java -cp out Main
```

Enter a move as `row col`, with indices starting at 0, for example `1 1`.

```
 X  X  X
 O  O  -
 -  -  -
Prakhar jeet gaya!
```

## Possible extensions

- Bot player (computer)
- Undo the last move
- Pluggable winning rules (Strategy pattern)
- More than 2 players on a bigger board
