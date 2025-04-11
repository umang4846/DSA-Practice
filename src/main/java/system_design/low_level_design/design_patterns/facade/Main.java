package system_design.low_level_design.design_patterns.facade;

public class Main {
    public static void main(String[] args) {
        RoomLights roomLights = new RoomLights();
        Television television = new Television();
        SoundSystem soundSystem = new SoundSystem();

        HomeTheaterFacade facade = new HomeTheaterFacade(roomLights, soundSystem,television);

        facade.watchMovie();
        System.out.println("------------------------------------");
        facade.stopWatchingMovie();

    }
}
