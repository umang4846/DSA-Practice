package system_design.low_level_design.design_patterns.template;

public class Customer {
    public static void main(String[] args) {
        StoreOrder storeOrder = new StoreOrder();
        storeOrder.processOrder();
        System.out.println("-------------------------------");

        OnlineOrder onlineOrder = new OnlineOrder();
        onlineOrder.isGiftWrap = true;
        onlineOrder.processOrder();
    }
}
