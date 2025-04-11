package system_design.low_level_design.design_patterns.abstract_factory;

public class IPhoneFactory extends PhoneStore{

    public static final String IPHONE12 = "iphone12";
    public static final String IPHONE13 = "iphone13";
    @Override
    Phone createPhone(String modelName) {
        if(modelName.equals(IPHONE12)){
            return new IPhone12();
        }else if (modelName.equals(IPHONE13)){
            return new IPhone13();
        }
        return null;
    }
}
