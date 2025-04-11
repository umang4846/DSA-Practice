package system_design.low_level_design.design_patterns.abstract_factory;

public class Main {
    public static void main(String[] args) {
        PhoneStore iPhone = new IPhoneFactory();
        iPhone.orderPhone(IPhoneFactory.IPHONE12);

        System.out.println("-------------------------------------------");

        PhoneStore oneplus = new OnePlusFactory();
        oneplus.orderPhone(OnePlusFactory.ONEPLUS9);
    }
}
