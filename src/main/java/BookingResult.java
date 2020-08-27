public class BookingResult {

    public BookingStatus status;
    public CabRecord cabRecord;

    public BookingResult(BookingStatus status) {
        this.status = status;
    }

    public BookingResult(BookingStatus status, CabRecord cabRecord) {
        this.status = status;
        this.cabRecord = cabRecord;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Status: ").append(status.name());
        if (cabRecord != null) {
            sb.append(" Cab no: " + cabRecord.cab.getRegistrationNumber());
        }
        return sb.toString();
    }
}
