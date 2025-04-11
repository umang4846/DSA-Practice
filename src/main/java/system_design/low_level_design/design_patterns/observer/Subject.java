package system_design.low_level_design.design_patterns.observer;

public interface Subject {
    void registerObserver(Observer o);
    void unregisterObserver(Observer o);
    void notifyObserver(String msg);
}
