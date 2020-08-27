import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CabManagement {

    public Map<String, City> cityCabs = new HashMap<>();

    public void registerCabs(String cityCode, Cab cab) {
        if (cityCabs.containsKey(cityCode)) {
            City city = cityCabs.get(cityCode);
            city.cityCatalog.add(new CabRecord(cab, CabStatus.Available, new Location(cityCode)));
        }
    }

    public void addCity(String cityName, String cityCode) {
        if (!cityCabs.containsKey(cityCode)) {
            cityCabs.put(cityCode, new City(cityName, cityCode));
        }
    }

    public BookingResult book(String source, String destination, Long startTime) {
        if (cityCabs.containsKey(source)) {
            Optional<CabRecord> availableCab = cityCabs.get(source).cityCatalog.stream().filter(cr -> cr.status == CabStatus.Available).findFirst();
            if (availableCab.isPresent()) {
                CabRecord cabRecord = availableCab.get();
                cabRecord.status = CabStatus.Booked;
                Record record = new Record(source, destination);
                record.startTime = startTime;
                cabRecord.records.add(new Record(source, destination));
                cabRecord.getLocation().cityName = "ON_TRIP";
                removeCab(source, cabRecord);
                addCity(destination, destination);
                return new BookingResult(BookingStatus.SUCCESS, cabRecord);
            }
            return new BookingResult(BookingStatus.NOT_AVAILABLE);
        } else {
            return new BookingResult(BookingStatus.OUT_OF_SERVICE_AREA);
        }
    }

    public void endTrip(CabRecord cabRecord) {
        int index = cabRecord.records.size() - 1;
        String currentCity = cabRecord.records.get(index).endCityCode;
        cabRecord.records.get(index).endTime = System.currentTimeMillis();
        cabRecord.status = CabStatus.Available;
        cabRecord.getLocation().cityName = currentCity;
        addCab(currentCity, cabRecord);
    }

    public void addCab(String cityCode, CabRecord cab) {
        cityCabs.get(cityCode).cityCatalog.add(cab);
    }

    public void removeCab(String cityCode, CabRecord cab) {
        cityCabs.get(cityCode).cityCatalog.remove(cab);
    }

    public void printRecords() {
        for(Map.Entry<String, City> entry: cityCabs.entrySet()) {
            for(CabRecord record: entry.getValue().cityCatalog) {
                System.out.println(record.cab);
                System.out.println(record.records);
            }
        }
    }

}
