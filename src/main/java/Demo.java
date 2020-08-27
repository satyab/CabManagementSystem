public class Demo {

    public static void main(String[] args) {
        CabManagement mgmt = new CabManagement();

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


        CabRecord cab1 = mgmt.book("BOM", "NSK", System.currentTimeMillis());


    }
}
