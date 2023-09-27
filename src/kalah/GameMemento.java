package kalah;

public class GameMemento {

    private Board savedBoard;
    private Player currentSavedPlayer;

    public GameMemento(Board board, Player player) {
        this.savedBoard = board;
        this.currentSavedPlayer = player;
    }

    public Board getSavedBoard() {
        return savedBoard;
    }

    public Player getCurrentSavedPlayer() {
        return currentSavedPlayer;
    }
}
