package machines;

public class Car extends Machine{
    public Car(Boolean isReadyToUse) {
        super(isReadyToUse);
    }

    @Override
    public String toString() {
        return "Car{}";
    }
}
