import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Game game = new Game();
        Game.welcomeMessage();
        while (true) {
            game.buildGameField();
            if (game.isGameEnd()) break;
            game.playersTurn(scan);
            game.checkWinner(game.humanPlayer);
            game.checkForDraw();
            if (game.isGameEnd()) break;
            game.computersTurn();
            game.buildGameField();
            game.checkWinner(game.computerPlayer);
            game.checkForDraw();
            if (game.isGameEnd()) break;

        }
    }
}