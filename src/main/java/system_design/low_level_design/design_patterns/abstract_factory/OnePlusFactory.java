package system_design.low_level_design.design_patterns.abstract_factory;

public class OnePlusFactory extends PhoneStore{

    public static final String ONEPLUS8 = "oneplus8";
    public static final String ONEPLUS9 = "oneplus9";
    @Override
    Phone createPhone(String modelName) {
        if(modelName.equals(ONEPLUS8)){
            return new OnePlus8();
        }else if (modelName.equals(ONEPLUS9)){
            return new OnePlus9();
        }
        return null;
    }
}
