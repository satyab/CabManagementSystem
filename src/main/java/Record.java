public class Record {

    public Long startTime;
    public Long endTime;
    public String startCityCode;
    public String endCityCode;

    public Record(String startCityCode, String endCityCode) {
        this.startCityCode = startCityCode;
        this.endCityCode = endCityCode;
    }

    @Override
    public String toString() {
        return " Start -> " + startCityCode +  " End -> " + endCityCode ;
    }

}
