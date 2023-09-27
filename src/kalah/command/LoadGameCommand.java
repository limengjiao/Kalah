package kalah.command;

import com.qualitascorpus.testsupport.IO;
import kalah.Game;

public class LoadGameCommand implements Command {

    private Game game;
    private IO io;

    public LoadGameCommand(Game game, IO io) {
        this.game = game;
        this.io = io;
    }

    @Override
    public void execute() {
        if (game.loadGame() == false) {
            io.println("No saved game");
        }
        ;
    }
}
