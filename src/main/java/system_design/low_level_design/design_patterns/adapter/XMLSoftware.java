package system_design.low_level_design.design_patterns.adapter;

public class XMLSoftware implements XMLData {

    @Override
    public void readXMLData() {
        System.out.println("UNDERSTAND ONLY XML DATA");
    }
}
