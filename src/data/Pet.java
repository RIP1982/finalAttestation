package data;

import java.util.Arrays;

public class Pet extends MansFriend {
    private int id;
    private String animalClassification;
    private String[] commands;

    public Pet(int id, String animalClassification, String animal, String name, String[] commands) {
        super(animal, name);
        this.id = id;
        this.animalClassification = animalClassification;
        this.commands = commands;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnimalClassification() {
        return animalClassification;
    }

    public void setAnimalClassification(String animalClassification) {
        this.animalClassification = animalClassification;
    }

    public String[] getCommands() {
        return commands;
    }

    public void setCommands(String[] commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", animalClassification='" + animalClassification + '\'' +
                ", animal='" + super.getAnimal() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", commands=" + Arrays.toString(commands) +
                '}';
    }
}
