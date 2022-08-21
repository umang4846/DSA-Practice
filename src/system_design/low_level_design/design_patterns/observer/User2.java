package system_design.low_level_design.design_patterns.observer;

public class User2 implements Observer{
    @Override
    public void update(String msg) {
        System.out.println("User 2 "+msg);
    }
}
