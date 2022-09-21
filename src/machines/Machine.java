package machines;

import java.io.Serializable;

public abstract class Machine implements Serializable {

    protected Boolean isReadyToUse;
    protected double fuelconsumption_l_Per_h;
    protected double performance_m2_Per_h;
    protected double fuelPrice;

    public Machine(Boolean isReadyToUse, double fuelconsumption_l_Per_h, double performance_m2_Per_h, double fuelPrice) {
        this.isReadyToUse = isReadyToUse;
        this.fuelconsumption_l_Per_h = fuelconsumption_l_Per_h;
        this.performance_m2_Per_h = performance_m2_Per_h;
        this.fuelPrice = fuelPrice;
    }
}
