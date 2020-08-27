public class WagonR extends Cab {
    Type type;
    String registrationNo;
    Long registrationDate;

    public WagonR(String registrationNo) {
        this.registrationNo = registrationNo;
        this.type = Type.MICRO;
        this.registrationDate = System.currentTimeMillis();
    }

    public Type getType() {
        return type;
    }

    @Override
    public Long getRegistrationTime() {
        return this.registrationDate;
    }

    @Override
    public String getRegistrationNumber() {
        return registrationNo;
    }
}
