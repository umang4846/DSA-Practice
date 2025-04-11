package system_design.low_level_design.design_patterns.facade;

public class HomeTheaterFacade {
    RoomLights roomLights;
    SoundSystem soundSystem;
    Television television;

    public HomeTheaterFacade(RoomLights roomLights, SoundSystem soundSystem, Television television) {
        this.roomLights = roomLights;
        this.soundSystem = soundSystem;
        this.television = television;
    }

    public void watchMovie(){
        soundSystem.switchOnSoundSystem();
        television.switchOnTV();
        roomLights.lightsDim();
    }

    public void stopWatchingMovie(){
        soundSystem.switchOffSoundSystem();
        television.switchOffTV();
        roomLights.lightsBright();
    }
}
