package kalah;

public class Game {

    private Board board;
    //    private IO io;
    private Player player_1;
    private Player player_2;
    private Player currentPlayer;
    private RobotStrategy robotStrategy;
    private GameCareTaker taker;

    public Game() {
        this.board = new Board();
        this.player_1 = new Player(1);
        this.player_2 = new Player(2);
        this.robotStrategy = new RobotStrategy(board, player_1, player_2);
        this.currentPlayer = player_1;
        this.taker = new GameCareTaker();
    }

    public String[] getBMFMove() {
        return robotStrategy.getBMFMove();
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean isCurrentPlayerHouseEmpty() {
        return board.isPlayerHouseEmpty(currentPlayer);
    }

    public int getCurrentPlayerHouseNSeedsNumber(int number) {
        return board.getPlayerHouseSeeds(currentPlayer, number);
    }

    public int getPlayerSumSeeds(int playerId) {
        if (playerId == 1) {
            return board.getPlayerSumSeeds(player_1);
        } else {
            return board.getPlayerSumSeeds(player_2);
        }
    }

    public void switchPlayer() {
        if (this.currentPlayer.getId() == 1) {
            this.currentPlayer = player_2;
        } else {
            this.currentPlayer = player_1;
        }
    }

    public int sowingSeeds(int number) {
        return board.sowing(currentPlayer, number);
    }

    public String[] buildCurrentBoardAsString(boolean vertical) {
        if (vertical == false) {
            return board.buildHorizontalBoard();
        } else {
            return board.buildVerticalBoard();
        }
    }

    public void resetGame() {
        this.board = new Board();
        this.player_1 = new Player(1);
        this.player_2 = new Player(2);
        this.currentPlayer = player_1;
        this.taker = new GameCareTaker();
    }

    public void saveGame() {
        taker.saveGame(this);
    }

    public boolean loadGame() {
        GameMemento memento = taker.loadGame();
        if (memento != null) {
            restoreMemento(memento);
            return true;
        } else {
            return false;
        }
    }

    public GameMemento createMemento() {
        return new GameMemento(board.clone(), currentPlayer);
    }

    public void restoreMemento(GameMemento memento) {
        board = memento.getSavedBoard();
        currentPlayer = memento.getCurrentSavedPlayer();
    }
}
