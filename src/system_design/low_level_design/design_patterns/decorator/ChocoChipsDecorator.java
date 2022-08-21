package system_design.low_level_design.design_patterns.decorator;

public class ChocoChipsDecorator extends IceCreamDecorator{

    IceCream iceCream;

    public ChocoChipsDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " with Choco Chips";
    }

    @Override
    int cost() {
        return iceCream.cost() + 25;
    }
}
