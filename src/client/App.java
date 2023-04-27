package client;


import data.Pet;
import util.Counter;
import view.View;
import service.IPetsRegistryService;
import service.PetsRegistryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

public class App {
    View ui;
    IPetsRegistryService petsRegistryService = new PetsRegistryService();
    ArrayList<Pet> petsList = new ArrayList<>();
    Logger logger = Logger.getAnonymousLogger();

    public App() {
        ui = new ConsoleView();
    }

    public void start() throws IOException {
        try (Counter counter = new Counter()){
            StringBuilder sb = new StringBuilder()
                    .append("\n ==== \n")
                    .append("1 - get a pet\n")
                    .append("2 - view list of commands\n")
                    .append("3 - view pets registry\n")
                    .append("4 - command training\n")
                    .append("0 - exit\n");

            while (true) {
                ui.set(sb.toString());
                System.out.printf("Enter your request, please: ");
                switch (ui.get()) {
                    case "1":
                        petsRegistryService.getAPet("src/petsRegistry.csv");
                        Counter.add();
                        logger.info(String.valueOf(counter));
                        break;
                    case "2":
                        petsRegistryService.viewListOfCommands("src/petsRegistry.csv");
                        break;
                    case "3":
                        petsRegistryService.viewPetsRegistry("src/petsRegistry.csv");
                        break;
                    case "4":
                        petsRegistryService.commandTraining("src/petsRegistry.csv");
                        break;
                    case "0":
                        return;
                }
            }
        }
    }
}
