package system_design.low_level_design.design_patterns.abstract_factory;

public abstract class PhoneStore {

    public Phone orderPhone(String modelName){
        Phone phone;
        phone = createPhone(modelName);
        phone.buildPhone();
        phone.assemblePhone();
        phone.packPhoneInBox();

        return phone;
    }

    abstract Phone createPhone(String modelName);

}
