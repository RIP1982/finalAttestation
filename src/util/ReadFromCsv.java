package util;


import data.Pet;
import data.PetsRegistry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromCsv {

    public static PetsRegistry readFromCsv(String pathName) throws IOException {
        try {
            ArrayList<Pet> petsList = new ArrayList<>();
            BufferedReader csvReader = new BufferedReader(new FileReader(pathName));
            String row;
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                int id = Integer.parseInt(data[0].replace("\"", ""));
                String animal = data[1].replace("\"", "");
                String name = data[2].replace("\"", "");
                String[] commands = data[3].replace("\"", "").split(" ");
                Pet pet = new Pet(id, animal, name, commands);
                petsList.add(pet);
            }
            csvReader.close();
            PetsRegistry petsRegistry = new PetsRegistry(petsList);
            return petsRegistry;
        } catch (Exception e) {
            return null;
        }
    }
}
