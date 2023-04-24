package data;

import java.util.ArrayList;

public class PackAnimalsRegistry {
    private ArrayList<PackAnimal> packAnimalsList;

    public PackAnimalsRegistry(ArrayList<PackAnimal> packAnimalsList) {
        this.packAnimalsList = packAnimalsList;
    }

    public ArrayList<PackAnimal> getPackAnimalsList() {
        return packAnimalsList;
    }

    public void setPackAnimalsList(ArrayList<PackAnimal> packAnimalsList) {
        this.packAnimalsList = packAnimalsList;
    }

    @Override
    public String toString() {
        return "PackAnimalsRegistry{" +
                "packAnimalsList=" + packAnimalsList +
                '}';
    }
}
