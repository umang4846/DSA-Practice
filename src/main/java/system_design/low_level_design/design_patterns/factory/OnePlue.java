package system_design.low_level_design.design_patterns.factory;

public class OnePlue implements Mobile{
    @Override
    public void createMobile() {
        System.out.println("Creating OnePlus Mobile Phone");
    }
}
