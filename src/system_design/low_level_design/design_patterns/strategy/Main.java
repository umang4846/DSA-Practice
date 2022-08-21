package system_design.low_level_design.design_patterns.strategy;

public class Main {

    public static void main(String[] args) {
        ApplyDiscount applyDiscount = new ApplyDiscount(new FlatDiscount());
        applyDiscount.getDiscount();

        applyDiscount.setStrategy(new CashbackDiscount());
        applyDiscount.getDiscount();
    }


}
