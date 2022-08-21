package system_design.low_level_design.design_patterns.singleton;

public class SingletonClassWay1 {
    private static SingletonClassWay1 obj;

    private SingletonClassWay1(){ }

    public static synchronized SingletonClassWay1 getInstance(){
        if(obj == null){
            obj = new SingletonClassWay1();
        }
        return obj;
    }

    /*
    * Note : used synchronized keyword to make method thread-safe, but making it synchronized
    * can increase waiting of other threads which impact the overall performance of system
    * */
}
