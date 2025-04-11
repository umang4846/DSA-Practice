package system_design.low_level_design.design_patterns.adapter;

public class JSONSoftware implements JSONData{
    @Override
    public void readJSONData() {
        System.out.println("UNDERSTAND ONLY JSON DATA");
    }
}
