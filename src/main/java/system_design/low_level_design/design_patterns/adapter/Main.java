package system_design.low_level_design.design_patterns.adapter;

public class Main {
    public static void main(String[] args) {
        XMLSoftware xmlSoftware  = new XMLSoftware();

        JSONData xmlAdapter = new XMLToJSONDataAdapter(xmlSoftware);
        xmlAdapter.readJSONData();
    }
}
