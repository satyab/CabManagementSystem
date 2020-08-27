import java.util.ArrayList;
import java.util.List;

public class CabRecord {
    Cab cab;
    List<Record> records;
    CabStatus status;

    public CabRecord(Cab cab, CabStatus status) {
        this.cab = cab;
        this.status = status;
        records = new ArrayList<Record>();
    }
}
