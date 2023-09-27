package kalah;

import com.qualitascorpus.testsupport.IO;
import kalah.command.LoadGameCommand;
import kalah.command.MoveHouseCommand;
import kalah.command.NewGameCommand;
import kalah.command.QuitGameCommand;
import kalah.command.SaveGameCommand;

public class GameController {

    private Game game;
    private IO io;
    private GameInvoker invoker;
    private GamePrinter printer;

    public GameController(Game game, IO io) {
        this.game = game;
        this.io = io;
        this.printer = new GamePrinter(io,game);
        this.invoker = assembleGameInvoker();
    }

    public void startGame(Game game, boolean vertical, boolean bmf) {
        //Main Game loop control
        while (true) {
            printer.printCurrentGameBoard(vertical);

            //if current player house is empty -> Game over with final winner
            if (game.isCurrentPlayerHouseEmpty()) {
                printer.printGameFinish(vertical);
                return;
            }
            //Prompt instructions for current player and get input value or get robot bmf move
            String input = getPlayerInput(bmf);
            invoker.executeCommand(input);
            if ("q".equals(input)) {
                return;
            }
        }
    }

    public String getPlayerInput(boolean bmf) {
        if (bmf == false || game.getCurrentPlayer().getId() == 1) {
            printer.printPlayerOptions(game.getCurrentPlayer().getId());
            String input = io.readFromKeyboard("Choice:");
            return input;
        } else {
            String[] bmfMove = game.getBMFMove();
            io.println(bmfMove[1]);
            return bmfMove[0];
        }
    }

    private GameInvoker assembleGameInvoker() {
        GameInvoker gameInvoker = new GameInvoker();
        gameInvoker.setCommand("n", new NewGameCommand(game));
        gameInvoker.setCommand("s", new SaveGameCommand(game));
        gameInvoker.setCommand("l", new LoadGameCommand(game, io));
        gameInvoker.setCommand("q", new QuitGameCommand(game, io, false, printer));
        gameInvoker.setCommand("1", new MoveHouseCommand(game, 1, io));
        gameInvoker.setCommand("2", new MoveHouseCommand(game, 2, io));
        gameInvoker.setCommand("3", new MoveHouseCommand(game, 3, io));
        gameInvoker.setCommand("4", new MoveHouseCommand(game, 4, io));
        gameInvoker.setCommand("5", new MoveHouseCommand(game, 5, io));
        gameInvoker.setCommand("6", new MoveHouseCommand(game, 6, io));
        return gameInvoker;
    }
}
