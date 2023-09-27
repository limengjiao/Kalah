package kalah;
import com.qualitascorpus.testsupport.IO;

public class GamePrinter {

    private IO io;
    private Game game;

    public GamePrinter(IO io, Game game){
        this.io = io;
        this.game = game;
    }

    public void printPlayerOptions(int currentPlayerId) {
        io.println("Player P" + currentPlayerId);
        io.println("    (1-6) - house number for move");
        io.println("    N - New game");
        io.println("    S - Save game");
        io.println("    L - Load game");
        io.println("    q - Quit");
    }

    public void printGameFinish(boolean vertical) {
        io.println("Game over");
        printCurrentGameBoard(vertical);
        printFinalGameResult();
    }
    public void printGameQuit(boolean vertical) {
        io.println("Game over");
        printCurrentGameBoard(vertical);
    }
    public void printCurrentGameBoard(boolean vertical) {
        String[] boardString = game.buildCurrentBoardAsString(vertical);
        int i = 0;
        while (i < boardString.length) {
            io.println(boardString[i]);
            i++;
        }
    }

    private void printFinalGameResult() {
        int sumSeeds_p1 = game.getPlayerSumSeeds(1);
        int sumSeeds_p2 = game.getPlayerSumSeeds(2);
        io.println("	player 1:" + sumSeeds_p1);
        io.println("	player 2:" + sumSeeds_p2);
        if (sumSeeds_p1 > sumSeeds_p2) {
            io.println("Player 1 wins!");
        } else if (sumSeeds_p1 < sumSeeds_p2) {
            io.println("Player 2 wins!");
        } else {
            io.println("A tie!");
        }
    }


}
