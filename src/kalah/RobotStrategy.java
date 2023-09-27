package kalah;

public class RobotStrategy {

    private Board board;

    private Player human;

    private Player robot;

    public RobotStrategy(Board board, Player human, Player robot) {
        this.board = board;
        this.human = human;
        this.robot = robot;
    }

    //get player2 (Robot) bmf selection
    public String[] getBMFMove() {
        String[] bmfMove = new String[2];
        //lowest-numbered house that leads to an additional move
        String[] bmfMove1 = bmfExtraMove(bmfMove);
        if (bmfMove1 != null) {
            return bmfMove1;
        }
        //lowest-numbered house that leads to a capture
        String[] bmfMove2 = bmfCapture(bmfMove);
        if (bmfMove2 != null) {
            return bmfMove2;
        }
        //lowest-numbered (first) house that has a legal move
        String[] bmfMove3 = bmfFirstLegalMove(bmfMove);
        if (bmfMove3 != null) {
            return bmfMove3;
        }
        return bmfMove;
    }

    private String[] bmfExtraMove(String[] bmfMove) {
        int i = 1;
        while (i < 7) {
            int seeds = board.getPlayerHouseSeeds(robot, i);
            if (seeds + i - 6 == 1) {
                bmfMove[0] = String.valueOf(i);
                bmfMove[1] = "Player P2 (Robot) chooses house #" + i + " because it leads to an extra move";
                return bmfMove;
            }
            i++;
        }
        return null;
    }

    private String[] bmfCapture(String[] bmfMove) {
        int j = 1;
        while (j < 7) {
            int seeds = board.getPlayerHouseSeeds(robot, j);
            //seeds only enough to sow own rest houses
            if (seeds != 0 && (seeds + j - 6 <= 0)) {
                int lastHouse = seeds + j;
                if (board.getPlayerHouseSeeds(robot, lastHouse) == 0
                        && board.getPlayerHouseSeeds(human, 6 - lastHouse + 1) > 0) {
                    bmfMove[0] = String.valueOf(j);
                    bmfMove[1] = "Player P2 (Robot) chooses house #" + j + " because it leads to a capture";
                    return bmfMove;
                }
            }
            //seeds enough to sow own rest houses -> own store -> all opponent houses->own houses (not exceed selected houses number)
            else if ((6 - j + 8) <= seeds && seeds <= 13) {
                int lastHouse = seeds - (6 - j) - 7;
                if (board.getPlayerHouseSeeds(robot, lastHouse) == 0) {
                    bmfMove[0] = String.valueOf(j);
                    bmfMove[1] = "Player P2 (Robot) chooses house #" + j + " because it leads to a capture";
                    return bmfMove;
                }
            }
            j++;
        }
        return null;
    }

    private String[] bmfFirstLegalMove(String[] bmfMove) {
        int k = 1;
        while (k < 7) {
            if (board.getPlayerHouseSeeds(robot, k) != 0) {
                bmfMove[0] = String.valueOf(k);
                bmfMove[1] = "Player P2 (Robot) chooses house #" + k + " because it is the first legal move";
                return bmfMove;
            }
            k++;
        }
        return null;
    }

}
