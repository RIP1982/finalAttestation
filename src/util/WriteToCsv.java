package util;

import data.Pet;
import data.PetsRegistry;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToCsv {
    public static void writeToCsv(PetsRegistry petsRegistry, String name) {
        ArrayList<Pet> petsList = petsRegistry.getPetsList();
        List<String[]> petToString = new ArrayList<>();
        for (Pet pet: petsList) {
            String[] petsListToString = new String[]{String.valueOf(pet.getId()), pet.getAnimal(),
                    pet.getName(), String.join(", ", pet.getCommands())};
            petToString.add(petsListToString);
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(name))) {
            writer.writeAll(petToString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
