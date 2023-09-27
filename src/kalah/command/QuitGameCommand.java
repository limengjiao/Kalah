package kalah.command;

import com.qualitascorpus.testsupport.IO;
import kalah.Game;
import kalah.GameController;
import kalah.GamePrinter;

public class QuitGameCommand implements Command {

    private Game game;
    private IO io;

    private boolean vertical;
    private GamePrinter printer;

    public QuitGameCommand(Game game, IO io, boolean vertical, GamePrinter printer) {
        this.game = game;
        this.io = io;
        this.vertical = vertical;
        this.printer = printer;
    }

    @Override
    public void execute() {
        printer.printGameQuit(vertical);
    }

}
