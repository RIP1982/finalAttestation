package data;

import java.util.ArrayList;

public class PetsRegistry {
    private ArrayList<Pet> petsList;

    public PetsRegistry(ArrayList<Pet> petsList) {
        this.petsList = petsList;
    }

    public ArrayList<Pet> getPetsList() {
        return petsList;
    }

    public void setPetsList(ArrayList<Pet> petsList) {
        this.petsList = petsList;
    }

    @Override
    public String toString() {
        return "PetsRegistry:" + petsList;
    }
}
