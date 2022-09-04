package machines;

public class CombineHarvester extends SelfPropelledVehicle{

    public CombineHarvester(Boolean isReadyToUse, double fuelConsumpition, double performance, double fuelPrice) {
        super(isReadyToUse, fuelConsumpition, performance, fuelPrice);
    }

    @Override
    public String toString() {
        return "CombineHarvester{" +
                "fuelConsumpition=" + fuelConsumpition +
                ", performance=" + performance +
                ", fuelPrice=" + fuelPrice +
                '}';
    }
}
