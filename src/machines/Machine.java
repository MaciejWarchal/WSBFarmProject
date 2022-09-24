package machines;

import java.io.Serializable;

public abstract class Machine implements Serializable {

    protected int number;
    protected Boolean isReadyToUse;
    protected double fuelconsumption_l_Per_h;
    protected double performance_m2_Per_h;
    protected double fuelPrice;

    public Machine(int number, Boolean isReadyToUse, double fuelconsumption_l_Per_h, double performance_m2_Per_h, double fuelPrice) {
        this.number = number;
        this.isReadyToUse = isReadyToUse;
        this.fuelconsumption_l_Per_h = fuelconsumption_l_Per_h;
        this.performance_m2_Per_h = performance_m2_Per_h;
        this.fuelPrice = fuelPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Boolean getReadyToUse() {
        return isReadyToUse;
    }

    public void setReadyToUse(Boolean readyToUse) {
        isReadyToUse = readyToUse;
    }

    public double getFuelconsumption_l_Per_h() {
        return fuelconsumption_l_Per_h;
    }

    public void setFuelconsumption_l_Per_h(double fuelconsumption_l_Per_h) {
        this.fuelconsumption_l_Per_h = fuelconsumption_l_Per_h;
    }

    public double getPerformance_m2_Per_h() {
        return performance_m2_Per_h;
    }

    public void setPerformance_m2_Per_h(double performance_m2_Per_h) {
        this.performance_m2_Per_h = performance_m2_Per_h;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "number=" + number +
                ", isReadyToUse=" + isReadyToUse +
                ", fuelconsumption_l_Per_h=" + fuelconsumption_l_Per_h +
                ", performance_m2_Per_h=" + performance_m2_Per_h +
                ", fuelPrice=" + fuelPrice +
                '}';
    }
}
