public class Demo {

    public static void main(String[] args) {
        CabManagement mgmt = new CabManagement();

        BookingResult result1 = mgmt.book("BOM", "NSK", System.currentTimeMillis());
        print(result1, mgmt);

        mgmt.addCity("Mumbai", "BOM");
        BookingResult result2 = mgmt.book("BOM", "NSK", System.currentTimeMillis());
        print(result2, mgmt);

        mgmt.registerCabs("BOM", new WagonR("001"));
        BookingResult result3 = mgmt.book("BOM", "NSK", System.currentTimeMillis());
        print(result3, mgmt);
        mgmt.endTrip(result3.cabRecord);
        print(result3, mgmt);


        mgmt.addCity("Pune", "PUN");
        mgmt.registerCabs("BOM", new WagonR("002"));
        mgmt.registerCabs("PUN", new WagonR("003"));
        BookingResult result4 = mgmt.book("BOM", "PUN", System.currentTimeMillis());
        print(result4, mgmt);
        mgmt.endTrip(result4.cabRecord);
        mgmt.printRecords();
        /*
        mgmt.addCity("Mumbai", "BOM");
        mgmt.addCity("Pune", "PUN");

        mgmt.registerCabs("BOM", new WagonR("001"));
        mgmt.registerCabs("BOM", new WagonR("002"));
        mgmt.registerCabs("BOM", new WagonR("003"));
        mgmt.registerCabs("BOM", new WagonR("004"));
        mgmt.registerCabs("BOM", new WagonR("005"));

        mgmt.registerCabs("PUN", new WagonR("101"));
        mgmt.registerCabs("PUN", new WagonR("102"));
        mgmt.registerCabs("PUN", new WagonR("103"));*/

    }

    private static void print(BookingResult result, CabManagement mgmt){
        System.out.println("===========================");
        System.out.println(result);
        System.out.println(mgmt.cityCabs);
        System.out.println("===========================");
        System.out.println();
    }
}
