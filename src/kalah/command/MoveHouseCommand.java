package kalah.command;

import com.qualitascorpus.testsupport.IO;
import kalah.Game;

public class MoveHouseCommand implements Command {

    private Game game;
    private int houseNumber;

    private IO io;

    public MoveHouseCommand(Game game, int houseNumber, IO io) {
        this.game = game;
        this.houseNumber = houseNumber;
        this.io = io;
    }

    @Override
    public void execute() {
        if (game.getCurrentPlayerHouseNSeedsNumber(houseNumber) != 0) {
            int sowResult = game.sowingSeeds(houseNumber);
            if (sowResult == 0) {
                game.switchPlayer();
            }
        } else {
            io.println("House is empty. Move again.");
        }
    }

}
