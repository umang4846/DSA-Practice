package system_design.low_level_design.design_patterns.factory;

public class Main {
    public static void main(String[] args) {
        MobileFactory mobileFactory = new MobileFactory();

        Mobile mobile = mobileFactory.createMobile(MobileFactory.IPHONE);
        mobile.createMobile();

        mobile = mobileFactory.createMobile(MobileFactory.ONEPLUE);
        mobile.createMobile();

        mobile = mobileFactory.createMobile(MobileFactory.REALME);
        mobile.createMobile();
    }
}
