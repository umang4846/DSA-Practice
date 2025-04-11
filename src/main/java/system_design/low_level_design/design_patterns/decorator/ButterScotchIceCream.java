package system_design.low_level_design.design_patterns.decorator;

public class ButterScotchIceCream extends IceCream{
    @Override
    public String getDescription() {
        return "Butter Scotch";
    }

    @Override
    int cost() {
        return 60;
    }
}
