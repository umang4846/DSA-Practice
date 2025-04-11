package system_design.low_level_design.design_patterns.template;

public abstract class OrderProcessTemplate {
    boolean isGiftWrap;

    protected abstract void selectProduct();
    protected abstract void makePayment();

    private final void packProduct(){
        if (isGiftWrap)
            System.out.println("Gift wrap product");
        else
            System.out.println("Simply packed product");
    }
    protected abstract void deliverProduct();

    public final void processOrder(){
        selectProduct();
        makePayment();
        packProduct();
        deliverProduct();
    }
}
