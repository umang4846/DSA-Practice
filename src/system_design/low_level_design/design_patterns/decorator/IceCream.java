package system_design.low_level_design.design_patterns.decorator;

public abstract class IceCream {
    String description;

    public String getDescription() {
        return description;
    }
    abstract int cost();
}
