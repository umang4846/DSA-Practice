package system_design.low_level_design.design_patterns.strategy;

public class CouponDiscount implements DiscountStrategy {
    @Override
    public void givenDiscount() {
        System.out.println("Coupon Discount");
    }
}
