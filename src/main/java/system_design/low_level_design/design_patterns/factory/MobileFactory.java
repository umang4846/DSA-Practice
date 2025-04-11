package system_design.low_level_design.design_patterns.factory;


public class MobileFactory {

    public static final String IPHONE = "IPHONE";
    public static final String ONEPLUE = "ONEPLUE";
    public static final String REALME = "REALME";

    public Mobile createMobile(String companyName) {
        if (companyName == null || companyName.isEmpty()) {
            return null;
        } else if (companyName.equals(IPHONE)) {
            return new IPhone();
        } else if (companyName.equals(ONEPLUE)) {
            return new OnePlue();
        } else if (companyName.equals(REALME)) {
            return new RealMe();
        } else {
            return null;
        }


    }
}
