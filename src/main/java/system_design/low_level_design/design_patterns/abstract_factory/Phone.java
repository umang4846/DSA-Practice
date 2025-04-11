package system_design.low_level_design.design_patterns.abstract_factory;

public abstract class Phone {
    String brand;
    String modelName;
    String bodyType;
    String phoneSize;

    void buildPhone(){
        System.out.println("Building phone of brand : "+brand);
        System.out.println("Phone model is : "+modelName);
        System.out.println("Size of phone is : "+phoneSize);
        System.out.println("Body type of Phone is  : "+bodyType);
    }

    void assemblePhone(){
        System.out.println("Assembling all parts of phone");
    }

    void packPhoneInBox(){
        System.out.println("Packing of phone");
    }
}
