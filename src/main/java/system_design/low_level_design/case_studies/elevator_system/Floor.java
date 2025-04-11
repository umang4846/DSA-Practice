package system_design.low_level_design.case_studies.elevator_system;

public class Floor {
    int floorNumber;
    ExternalDispatcher externalDispatcher;


    public Floor(int floorNumber){
        this.floorNumber = floorNumber;
        externalDispatcher = new ExternalDispatcher();
    }
    public void pressButton(Direction direction) {

        externalDispatcher.submitExternalRequest(floorNumber, direction);
    }
}
