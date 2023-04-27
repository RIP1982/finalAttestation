package service;

import data.Pet;
import data.PetsRegistry;
import util.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class PetsRegistryService implements IPetsRegistryService {
    Logger logger = Logger.getAnonymousLogger();

    @Override
    public PetsRegistry getAPet(String pathName) throws IOException, NullPointerException {
        PetsRegistry petsRegistryOld = ReadFromCsv.readFromCsv(pathName);
        ArrayList<Pet> petsList = new ArrayList<>();
        try {
            Pet pet = ReadFromConsole.readFromConsole();
            if (petsRegistryOld != null) {
                petsList = petsRegistryOld.getPetsList();
                int maxIdPetsList = FindMaxIndex.findMaxIndex(petsList);
                pet.setId(maxIdPetsList + 1);
                petsList.add(pet);
                PetsRegistry petsRegistry = new PetsRegistry(petsList);
                WriteToCsv.writeToCsv(petsRegistry, pathName);
                return petsRegistry;
            } else {
                pet.setId(1);
                petsList.add(pet);
                PetsRegistry petsRegistry = new PetsRegistry(petsList);
                WriteToCsv.writeToCsv(petsRegistry, pathName);
                return petsRegistry;
            }
        } catch (Exception e) {
            System.out.println();
        }
        return null;
    }

    @Override
    public void viewListOfCommands(String pathName) throws IOException {
        ArrayList<Pet> petsList = ReadFromCsv.readFromCsv(pathName).getPetsList();
        System.out.printf("Enter the request(name or kind of animal): ");
        String request = new Scanner(System.in).nextLine();
        ArrayList<String> commands = new ArrayList<>();
        if (ReadFromConsole.isWrongRequest(request, pathName) == false) {
            for (Pet pet: petsList) {
                if (pet.getName().equals(request) || pet.getAnimal().equals(request)) {
                    ArrayList<String> petCommands = pet.getCommands();
                    for(String command: petCommands) {
                        commands.add(command);
                    }
                }
            }
            logger.info(request + " commands: " + commands.toString());
        } else {
            logger.info("Wrong request!");
        }
    }

    @Override
    public void viewPetsRegistry(String pathName) throws IOException {
        logger.info(ReadFromCsv.readFromCsv(pathName).toString());
    }

    @Override
    public void commandTraining(String pathName) throws IOException {
        ArrayList<Pet> petsList = ReadFromCsv.readFromCsv(pathName).getPetsList();
        System.out.printf("Enter the name of animal: ");
        String request = new Scanner(System.in).nextLine();
        ArrayList<String> commands = new ArrayList<>();
        if (ReadFromConsole.isWrongRequest(request, pathName) == false) {
            for (Pet pet: petsList) {
                if (pet.getName().equals(request)) {
                    ArrayList<String> petCommands = pet.getCommands();
                    ArrayList<String> setCommands = ReadFromConsole.setCommand();
                    logger.info(setCommands.toString());
                    for (String command : petCommands) {
                        setCommands.add(command);
                    }
                    pet.setCommands(setCommands);
                    PetsRegistry petsRegistry = new PetsRegistry(petsList);
                    WriteToCsv.writeToCsv(petsRegistry, pathName);
                    logger.info(request + " commands: " + setCommands);
                }
            }
        } else {
            logger.info("Wrong request!");
        }
    }
}
