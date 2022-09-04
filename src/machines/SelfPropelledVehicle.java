package machines;

public abstract class SelfPropelledVehicle extends Machine{
    protected double fuelConsumpition;
    protected double performance;
    protected double fuelPrice;

    public SelfPropelledVehicle(Boolean isReadyToUse, double fuelConsumpition, double performance, double fuelPrice) {
        super(isReadyToUse);
        this.fuelConsumpition = fuelConsumpition;
        this.performance = performance;
        this.fuelPrice = fuelPrice;
    }

}
