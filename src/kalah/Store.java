package kalah;

public class Store {

    private int storeSum;

    public Store() {
        this.storeSum = 0;
    }

    public Store(int sum) {
        this.storeSum = sum;
    }

    public int getStoreSeeds() {
        return storeSum;
    }

    public void sowInStore() {
        storeSum++;
    }

    public void addCaptureSeedsInStore(int seedsNumber) {
        storeSum = storeSum + seedsNumber;
    }

}
