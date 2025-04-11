package system_design.low_level_design.design_patterns.template;

public class StoreOrder extends OrderProcessTemplate{
    @Override
    protected void selectProduct() {
        System.out.println("Selecting product on store");
    }

    @Override
    protected void makePayment() {
        System.out.println("Making cash/card payment at store");
    }

    @Override
    protected void deliverProduct() {
        System.out.println("Product delivered to customer");
    }
}
