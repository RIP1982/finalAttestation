package data;

import java.util.ArrayList;
import java.util.logging.Logger;


public class Pet extends MansFriend {
    private int id;
    private ArrayList<String> commands;

    public Pet(int id, String animal, String name, ArrayList<String> commands) {
        super(animal, name);
        this.id = id;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "\n" + "Pet{" +
                "id=" + id +
                ", animal='" + super.getAnimal() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", commands=" + commands +
                '}';
    }
}
