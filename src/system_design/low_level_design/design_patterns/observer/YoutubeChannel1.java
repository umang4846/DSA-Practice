package system_design.low_level_design.design_patterns.observer;

import java.util.ArrayList;

public class YoutubeChannel1 implements Subject{
    ArrayList<Observer> observerList;

    public YoutubeChannel1() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        int index = observerList.indexOf(o);
        if(index >= 0){
            observerList.remove(index);
        }
    }

    @Override
    public void notifyObserver(String msg) {
        for(Observer o : observerList){
            o.update(msg);
        }
    }

    void newVideoAdded(String msg){
        notifyObserver(msg);
    }
}
