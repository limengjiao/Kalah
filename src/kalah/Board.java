package kalah;

import javax.swing.BorderFactory;

public class Board {

    private House house1;
    private Store store1;
    private House house2;
    private Store store2;

    private BoardAction boardAction;

    public Board() {
        this.house1 = new House();
        this.store1 = new Store();
        this.house2 = new House();
        this.store2 = new Store();
        this.boardAction = new BoardAction();
    }

    //Check if any player's house is empty
    public boolean isPlayerHouseEmpty(Player player) {
        if (player.getId() == 1) {
            for (int i = 1; i <= 6; i++) {
                if (house1.getHouseSeeds(i) != 0) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i <= 6; i++) {
                if (house2.getHouseSeeds(i) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //Return sum seeds of the player(store + houses)
    public int getPlayerSumSeeds(Player player) {
        if (player.getId() == 1) {
            return store1.getStoreSeeds() + house1.getTotalSeeds();
        } else {
            return store2.getStoreSeeds() + house2.getTotalSeeds();
        }
    }

    //Return the player house n seeds
    public int getPlayerHouseSeeds(Player player, int number) {
        if (player.getId() == 1) {
            return house1.getHouseSeeds(number);
        } else {
            return house2.getHouseSeeds(number);
        }
    }

    public int sowing(Player player, int number) {
        if (player.getId() == 1) {
            return boardAction.sowing(house1, house2, store1, number);
        } else {
            return boardAction.sowing(house2, house1, store2, number);
        }
    }

    public String[] buildHorizontalBoard() {
        String[] boardString = new String[5];
        boardString[0] = "+----+-------+-------+-------+-------+-------+-------+----+";
        boardString[1] =
                "| P2 | 6[" + formatPadding(house2.getHouseSeeds(6)) + "] | 5[" + formatPadding(house2.getHouseSeeds(5))
                        + "] | 4[" + formatPadding(house2.getHouseSeeds(4)) + "] | 3[" + formatPadding(
                        house2.getHouseSeeds(3)) + "] | 2[" + formatPadding(house2.getHouseSeeds(2)) + "] | 1["
                        + formatPadding(house2.getHouseSeeds(1)) + "] | " + formatPadding(store1.getStoreSeeds())
                        + " |";
        boardString[2] = "|    |-------+-------+-------+-------+-------+-------|    |";
        boardString[3] = "| " + formatPadding(store2.getStoreSeeds()) + " | 1[" + formatPadding(house1.getHouseSeeds(1))
                + "] | 2[" + formatPadding(house1.getHouseSeeds(2)) + "] | 3[" + formatPadding(house1.getHouseSeeds(3))
                + "] | 4[" + formatPadding(house1.getHouseSeeds(4)) + "] | 5[" + formatPadding(house1.getHouseSeeds(5))
                + "] | 6[" + formatPadding(house1.getHouseSeeds(6)) + "] | P1 |";
        boardString[4] = "+----+-------+-------+-------+-------+-------+-------+----+";
        return boardString;
    }

    public String[] buildVerticalBoard() {
        String[] boardString = new String[12];
        boardString[0] = "+---------------+";
        boardString[1] = "|       | P2 " + formatPadding(store2.getStoreSeeds()) + " |";
        boardString[2] = "+-------+-------+";
        boardString[3] =
                "| 1[" + formatPadding(house1.getHouseSeeds(1)) + "] | 6[" + formatPadding(house2.getHouseSeeds(6))
                        + "] |";
        boardString[4] =
                "| 2[" + formatPadding(house1.getHouseSeeds(2)) + "] | 5[" + formatPadding(house2.getHouseSeeds(5))
                        + "] |";
        boardString[5] =
                "| 3[" + formatPadding(house1.getHouseSeeds(3)) + "] | 4[" + formatPadding(house2.getHouseSeeds(4))
                        + "] |";
        boardString[6] =
                "| 4[" + formatPadding(house1.getHouseSeeds(4)) + "] | 3[" + formatPadding(house2.getHouseSeeds(3))
                        + "] |";
        boardString[7] =
                "| 5[" + formatPadding(house1.getHouseSeeds(5)) + "] | 2[" + formatPadding(house2.getHouseSeeds(2))
                        + "] |";
        boardString[8] =
                "| 6[" + formatPadding(house1.getHouseSeeds(6)) + "] | 1[" + formatPadding(house2.getHouseSeeds(1))
                        + "] |";
        boardString[9] = "+-------+-------+";
        boardString[10] = "| P1 " + formatPadding(store1.getStoreSeeds()) + " |       |";
        boardString[11] = "+---------------+";
        return boardString;
    }

    private String formatPadding(int result) {
        return String.format("%2s", result);
    }

    public Board clone() {
        Board clonedBoard = new Board();
        clonedBoard.house1 = this.house1.clone();
        clonedBoard.house2 = this.house2.clone();
        clonedBoard.store1 = new Store(this.store1.getStoreSeeds());
        clonedBoard.store2 = new Store(this.store2.getStoreSeeds());
        return clonedBoard;
    }

}



