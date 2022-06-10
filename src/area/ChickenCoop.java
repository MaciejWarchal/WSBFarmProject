package area;

public class ChickenCoop extends Bulding{

    private int capacityOfChickens;
    private  int currentNumberOfChickens;

    public ChickenCoop(int number, Border border, double price, int capacityOfChickens, int currentNumberOfChickens) {
        super(number, border, price);
        this.capacityOfChickens = capacityOfChickens;
        this.currentNumberOfChickens = currentNumberOfChickens;
    }

}
