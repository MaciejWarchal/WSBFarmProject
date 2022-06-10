package area;

public class CowShed extends Bulding{

    private int noumerOfCows;

    public CowShed(int number, Border border, double price, int noumerOfCows) {
        super(number, border, price);
        this.noumerOfCows = noumerOfCows;
    }
}
