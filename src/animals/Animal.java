package animals;

public class Animal {

    final protected String spacies;
    final protected String name;
    protected double weight;
    protected int age;
    protected boolean isALive;
    protected int HydrationLevel;
    protected int EnergyLevel;
    //protected building*********

    public Animal(String spacies, String name, double weight, int age, boolean isALive) {
        this.spacies = spacies;
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.isALive = isALive;
    }
}
