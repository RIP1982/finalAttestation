package data;

public class MansFriend {
    private String animal;
    private String name;

    public MansFriend(String animal, String name) {
        this.animal = animal;
        this.name = name;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MansFriend{" +
                "animal='" + animal + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
