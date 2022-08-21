package system_design.low_level_design.design_patterns.singleton;

public class SingletonClassWay2 {
    private static SingletonClassWay2 obj = new SingletonClassWay2();

    private SingletonClassWay2() {
    }

    public static SingletonClassWay2 getInstance() {
        return obj;
    }
}
