import java.util.LinkedList;
import java.util.List;

public class City {
    String name;
    String code;
    List<CabRecord> cityCatalog = new LinkedList<CabRecord>();

    public City(String name, String code){
        this.name = name;
        this.code = code;
    }
}
