package system_design.low_level_design.design_patterns.decorator;

public class ChocolateIceCream extends IceCream{
    @Override
    public String getDescription() {
        return "Chocolate";
    }

    @Override
    int cost() {
        return 70;
    }
}
