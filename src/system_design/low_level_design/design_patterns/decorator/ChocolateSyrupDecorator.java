package system_design.low_level_design.design_patterns.decorator;

public class ChocolateSyrupDecorator extends IceCreamDecorator{

    IceCream iceCream;

    public ChocolateSyrupDecorator(IceCream iceCream) {
        this.iceCream = iceCream;
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " with Chocolate Syrup";
    }

    @Override
    int cost() {
        return iceCream.cost() + 30;
    }
}
