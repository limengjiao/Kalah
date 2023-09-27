package kalah;

public class GameCareTaker {

    private GameMemento memento;

    public void saveGame(Game game) {
        this.memento = game.createMemento();
    }

    public GameMemento loadGame() {
        return this.memento;
    }

}
