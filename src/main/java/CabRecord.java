import java.util.ArrayList;
import java.util.List;

public class CabRecord {
    Cab cab;
    List<Record> records;
    CabStatus status;
    Location location;

    public CabRecord(Cab cab, CabStatus status, Location location) {
        this.cab = cab;
        this.status = status;
        records = new ArrayList<Record>();
        this.location = location;
    }

    public Location getLocation() {
        return this.location;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CabRecord) {
            return ((CabRecord)obj).cab.getRegistrationNumber().equals(this.cab.getRegistrationNumber());
        }
        return false;
    }

    @Override
    public String toString() {
        return " " + cab.toString() +  " : Status: " + status.toString();
    }
}
