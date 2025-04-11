package system_design.low_level_design.design_patterns.factory;

public class RealMe implements Mobile{
    @Override
    public void createMobile() {
        System.out.println("Creating RealMe Mobile Phone");
    }
}
