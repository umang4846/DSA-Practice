package system_design.low_level_design.design_patterns.strategy;

public class ApplyDiscount {
    DiscountStrategy discountStrategy;

    public ApplyDiscount(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    void getDiscount() {
        discountStrategy.givenDiscount();
    }

    void setStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}
