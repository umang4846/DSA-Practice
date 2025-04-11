package system_design.low_level_design.design_patterns.command;

public class Main {
    public static void main(String[] args) {
        TubeLight tubeLight = new TubeLight();

        TubelightOnCommand tubelightOnCommand = new TubelightOnCommand(tubeLight);
        RemoteController remoteController = new RemoteController(tubelightOnCommand);
        remoteController.pressButton();

        TubelightOffCommand tubelightOffCommand = new TubelightOffCommand(tubeLight);
        remoteController.setCommand(tubelightOffCommand);
        remoteController.pressButton();

    }
}
