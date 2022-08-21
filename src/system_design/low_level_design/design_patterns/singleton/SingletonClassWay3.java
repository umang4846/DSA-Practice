package system_design.low_level_design.design_patterns.singleton;


public class SingletonClassWay3 {
    private volatile static SingletonClassWay3 obj;

    private SingletonClassWay3() {
    }

    public static SingletonClassWay3 getInstance() {
        return obj;
    }
}
