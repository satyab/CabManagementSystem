public abstract class Cab {
    public abstract Type getType();
    public abstract Long getRegistrationTime();
    public abstract String getRegistrationNumber();

    @Override
    public String toString() {
        return " Cab no: " + getRegistrationNumber();
    }
}
