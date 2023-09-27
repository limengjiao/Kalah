package kalah;

public class BoardAction {

    public static int sowing(House house, House houseOpponent, Store store, int number) {
        //Clear the chosen house
        int seeds = house.getHouseSeeds(number);
        house.clearHouse(number);

        //Sow the seeds follow 'own houses' -> 'own store' -> 'opponent houses'
        while (seeds > 0) {
            //Sow player's own houses
            for (int i = number + 1; i < 7 && seeds > 0; i++) {
                house.sowInHouse(i);
                seeds--;
                number = 0;
                //check if capture while finish sow last seed
                if (seeds == 0 && ifCaptured(house, houseOpponent, i)) {
                    //capture seeds
                    capture(house, houseOpponent, store, i);
                }
            }
            //Sow player store
            if (seeds > 0) {
                store.sowInStore();
                seeds--;
                number = 0;
                if (seeds == 0) {
                    return 1;
                }
            }
            //Sow opponent player house
            if (seeds > 0) {
                for (int j = 1; j < 7 && seeds > 0; j++) {
                    houseOpponent.sowInHouse(j);
                    seeds--;
                }
            }
        }
        return 0;
    }

    //check if capture
    private static boolean ifCaptured(House house, House houseOpponent, int number) {
        //last sowed house = 1 and opposite house > 0
        if (house.getHouseSeeds(number) == 1 && houseOpponent.getHouseSeeds(6 - number + 1) > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void capture(House house, House houseOpponent, Store store, int number) {
        int captureCount = houseOpponent.getHouseSeeds(6 - number + 1) + 1;
        //clear both house
        house.clearHouse(number);
        houseOpponent.clearHouse(6 - number + 1);
        //move captured seeds to own store
        store.addCaptureSeedsInStore(captureCount);
    }
}

