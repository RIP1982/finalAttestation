package util;

import data.Pet;
import java.util.Scanner;
import java.util.logging.Logger;

public class ReadFromConsole {
    public static Pet readFromConsole() {
        try {
            int id = 0;
            System.out.printf("animal: ");
            String animal = (new Scanner(System.in).nextLine());
            System.out.printf("name: ");
            String name = (new Scanner(System.in).nextLine());
            System.out.printf("commands: ");
            String[] commands = new String[]{(new Scanner(System.in).nextLine())};
            Pet pet = new Pet(id, animal, name, commands);
            return pet;
        } catch (Exception e) {
            Logger logger = Logger.getAnonymousLogger();
            logger.info("You entered wrong data!");
        }
        return null;
    }
}
