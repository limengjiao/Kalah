package kalah;

import java.util.Arrays;

public class House {

    private int houseCount = 6;
    private int seedsPerHouse = 4;
    private int[] houses;
    private int count = 0;

    public House() {
        this.houses = new int[houseCount];
        for (int i = 0; i < houseCount; i++) {
            houses[i] = seedsPerHouse;
            count = count + seedsPerHouse;
        }
    }

    public int getTotalSeeds() {
        return this.count;
    }

    public int getHouseSeeds(int houseNumber) {
        return houses[houseNumber - 1];
    }

    public void sowInHouse(int houseNumber) {
        houses[houseNumber - 1]++;
        count++;
    }

    public void clearHouse(int houseNumber) {
        int seeds = houses[houseNumber - 1];
        houses[houseNumber - 1] = 0;
        count = count - seeds;
    }

    public House clone() {
        House clonedHouse = new House();
        clonedHouse.houseCount = this.houseCount;
        clonedHouse.seedsPerHouse = this.seedsPerHouse;
        clonedHouse.count = this.count;
        clonedHouse.houses = Arrays.copyOf(this.houses, this.houses.length);
        return clonedHouse;
    }
}
