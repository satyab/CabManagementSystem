import java.io.StringBufferInputStream;
import java.util.LinkedList;
import java.util.List;

public class City {
    String name;
    String code;
    List<CabRecord> cityCatalog = new LinkedList<>();

    public City(String name, String code){
        this.name = name;
        this.code = code;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(" Name :" + name);
        sb.append(" Code :" + code);
        sb.append(" Cabs :" + cityCatalog.toString());
        return sb.toString();
    }
}
