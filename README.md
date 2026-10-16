# Low Level Design (LLD) in Java

Low-level design and machine coding problems, solved in plain Java.

Every problem follows the same approach:

1. **Requirements** – clarify what the system must do
2. **Entities** – pick out the nouns that become classes
3. **Relationships** – who has whom, and how many
4. **Classes and methods** – the data each class holds and the work it does
5. **Code** – working, runnable code

## Problems

| # | Problem | Concepts |
|---|---------|----------|
| 1 | [Tic-Tac-Toe](TicTacToe) | OOP basics, N×N board, game loop, O(N) win check, input validation |

## Running a problem

Each folder is a standalone IntelliJ project. Open the folder in IntelliJ and run `Main`, or use the terminal:

```bash
cd TicTacToe
javac -d out src/*.java
java -cp out Main
```

Requires Java 17+.
