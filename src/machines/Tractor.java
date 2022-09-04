package machines;

public class Tractor extends SelfPropelledVehicle{


    public Tractor(Boolean isReadyToUse, double fuelConsumpition, double performance, double fuelPrice) {
        super(isReadyToUse, fuelConsumpition, performance, fuelPrice);
    }

    @Override
    public String toString() {
        return "Tractor{" +
                "fuelConsumpition=" + fuelConsumpition +
                ", performance=" + performance +
                ", fuelPrice=" + fuelPrice +
                '}';
    }
}
