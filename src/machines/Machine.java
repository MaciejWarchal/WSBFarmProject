package machines;

public abstract class Machine {
    private Boolean isReadyToUse;

    public Machine(Boolean isReadyToUse) {
        this.isReadyToUse = isReadyToUse;
    }
}
