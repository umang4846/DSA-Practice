package system_design.low_level_design.design_patterns.strategy;

public class CashbackDiscount implements DiscountStrategy {
    @Override
    public void givenDiscount() {
        System.out.println("Cashback Discount");
    }
}
