package util;

import data.Pet;

import java.util.ArrayList;

public class FindMaxIndex {
    public static int findMaxIndex(ArrayList<Pet> list) {
        int maxIndex = 0;
        for (Pet pet: list) {
            if (maxIndex < pet.getId()) {
                maxIndex = pet.getId();
            }
        }
        return maxIndex;
    }
}
