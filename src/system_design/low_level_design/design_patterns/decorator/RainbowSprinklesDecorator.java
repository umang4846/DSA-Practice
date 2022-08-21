package system_design.low_level_design.design_patterns.decorator;

public class RainbowSprinklesDecorator extends IceCreamDecorator{

    IceCream iceCream;

    public RainbowSprinklesDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " with Rainbow Sprinkle";
    }

    @Override
    int cost() {
        return iceCream.cost() + 20;
    }
}
