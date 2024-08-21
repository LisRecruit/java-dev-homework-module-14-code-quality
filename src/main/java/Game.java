import java.util.Scanner;

public class Game {
    char humanPlayer = 'X';
    char computerPlayer = 'O';

    boolean boxAvailable = false;
    boolean boxEmpty = false;
    byte winner = 0;
    char[] box = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int[][] winningCombinations = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
    };

    public static void welcomeMessage() {
        System.out.println("Enter box number to select. Enjoy!\n");
    }

    public void setWinner(byte winner) {
        this.winner = winner;
    }

    public void playersTurn(Scanner scan) {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (box[input - 1] == humanPlayer || box[input - 1] == computerPlayer)
                    System.out.println("That one is already in use. Enter another.");
                else {
                    box[input - 1] = 'X';
                    break;
                }
            } else
                System.out.println("Invalid input. Enter again.");
        }
    }

    public boolean isGameEnd() {
        if (winner == 1) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 2) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == 3) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    public boolean buildGameField() {
        System.out.println("\n\n " + box[0] + " | " + box[1] + " | " + box[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[3] + " | " + box[4] + " | " + box[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + box[6] + " | " + box[7] + " | " + box[8] + " \n");
        if (!boxEmpty) {
            for (int i = 0; i < 9; i++)
                box[i] = ' ';
            boxEmpty = true;
        }
        return boxEmpty;
    }

    public void checkWinner(char player) {
        for (int[] combination : winningCombinations) {
            boolean isWinningCombination = true;

            for (int index : combination) {
                if (box[index] != player) {
                    isWinningCombination = false;
                    break;
                }
            }

            if (isWinningCombination) {
                if (player == humanPlayer) {
                    this.setWinner((byte) 1);
                } else if (player == computerPlayer) {
                    this.setWinner((byte) 2);
                }
            }
        }
    }

    public void checkForDraw() {
        boxAvailable = false;

        for (int i = 0; i < 9; i++) {
            if (box[i] != humanPlayer && box[i] != computerPlayer) {
                boxAvailable = true;
                break;
            }
        }
        if (!boxAvailable && winner != 1 && winner != 2) {
            winner = 3;
        }
    }

    public void computersTurn() {
        while (true) {
            byte rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (box[rand - 1] != humanPlayer && box[rand - 1] != computerPlayer) {
                box[rand - 1] = computerPlayer;
                break;
            }
        }
    }

}
