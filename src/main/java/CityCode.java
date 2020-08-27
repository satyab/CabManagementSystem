public enum CityCode {

   Mumbai("BOM"), Pune("PUN");

   private String code;

   private CityCode(String code) {
        this.code = code;
   }

   public String getCode() {
       return this.code;
   }

   public String getName() {
       return this.name();
   }
}
