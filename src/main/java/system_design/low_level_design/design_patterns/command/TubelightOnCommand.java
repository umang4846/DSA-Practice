package system_design.low_level_design.design_patterns.command;

public class TubelightOnCommand implements Command {
    TubeLight tubeLight;

    public TubelightOnCommand(TubeLight tubeLight) {
        this.tubeLight = tubeLight;
    }

    @Override
    public void execute() {
        tubeLight.switchOn();
    }
}
