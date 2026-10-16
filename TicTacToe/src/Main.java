import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Prakhar", Symbol.X);
        Player p2 = new Player("Rahul", Symbol.O);

        Game game = new Game(3, List.of(p1, p2));
        game.play();
    }
}
