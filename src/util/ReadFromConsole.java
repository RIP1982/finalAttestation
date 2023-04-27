package util;

import client.ConsoleView;
import data.Pet;
import view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ReadFromConsole {
    public static Pet readFromConsole() {
        View ui = new ConsoleView();
        int id = 0;
        System.out.printf("animal: ");
        String animal = (new Scanner(System.in).nextLine());
        System.out.printf("name: ");
        String name = (new Scanner(System.in).nextLine());
        ArrayList<String> command = setCommand();
        if (animal.length() != 0 && name.length() != 0 && command.size() != 0) {
            Pet pet = new Pet(id, animal, name, command);
            return pet;
        }
        return null;
    }

    public static ArrayList<String> setCommand() {
        View ui = new ConsoleView();
        ArrayList<String> commands = new ArrayList<>();
        StringBuilder sb = new StringBuilder()
                .append("\n ==== \n")
                .append("1 - new command\n")
                .append("0 - exit\n");
        while (true) {
            ui.set(sb.toString());
            System.out.printf("Enter your request, please: ");
            switch (ui.get()) {
                case "1":
                    System.out.printf("new command: ");
                    commands.add(new Scanner(System.in).nextLine());
                    break;
                case "0":
                    return commands;
            }
        }
    }

    public static boolean isWrongRequest(String request, String pathName) throws IOException {
        ArrayList<Pet> petsList = ReadFromCsv.readFromCsv(pathName).getPetsList();
        for (Pet pet: petsList) {
            if (pet.getName().equals(request) || pet.getAnimal().equals(request)) {
                return false;
            }
        }
        return true;
    }
}
