package service;

import data.PetsRegistry;

import java.io.IOException;
import java.util.ArrayList;

public interface IPetsRegistryService <T extends PetsRegistry>{
    T getAPet(String pathName) throws IOException, NullPointerException;
    void viewListOfCommands(String pathName) throws IOException;
    void viewPetsRegistry(String pathName) throws IOException;
    void commandTraining(String pathName) throws IOException;
}
