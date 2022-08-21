package system_design.low_level_design.design_patterns.strategy;

public class FlatDiscount implements DiscountStrategy{
    @Override
    public void givenDiscount() {
        System.out.println("Flat Discount");
    }
}
