import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CabManagement {

    private Map<String, City> cityCabs = new HashMap<>();

    public void registerCabs(String cityCode, Cab cab) {
        if (cityCabs.containsKey(cityCode)) {
            City city = cityCabs.get(cityCode);
            city.cityCatalog.add(new CabRecord(cab, CabStatus.Available));
        }
    }

    public void addCity(String cityName, String cityCode) {
        if (!cityCabs.containsKey(cityCode)) {
            cityCabs.put(cityCode, new City(cityName, cityCode));
        }
    }

    public CabRecord book(String source, String destination, Long startTime) {
        CabRecord cabRecord = null;
        if (cityCabs.containsKey(source)) {
            addCity(destination, destination);
            Optional<CabRecord> availableCab = cityCabs.get(source).cityCatalog.stream().filter(cr -> cr.status == CabStatus.Available).findFirst();
            if (availableCab.isPresent()) {
                cabRecord = availableCab.get();
                cabRecord.status = CabStatus.Booked;
                Record record = new Record(source, destination);
                record.startTime = startTime;
                cabRecord.records.add(new Record(source, destination));

            }
        }
        return cabRecord;
    }

    public void endTrip(CabRecord cabRecord) {
        int index = cabRecord.records.size() - 1;
        cabRecord.records.get(index).endTime = System.currentTimeMillis();
        cabRecord.status = CabStatus.Available;
        cabRecord.cab.getLocation().cityName = cabRecord.records.get(index).endCityCode;
        addCab(cabRecord);
    }

    public void addCab(CabRecord cab) {

    }

    public void removeCab(CabRecord cab) {

    }

}
