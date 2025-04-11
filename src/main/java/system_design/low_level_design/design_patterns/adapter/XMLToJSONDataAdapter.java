package system_design.low_level_design.design_patterns.adapter;

public class XMLToJSONDataAdapter implements JSONData{

    XMLData xmlData;

    XMLToJSONDataAdapter(XMLData xmlData){
        this.xmlData = xmlData;
    }
    @Override
    public void readJSONData() {
        xmlData.readXMLData();
        System.out.println("Convert here XML data to JSON data");
    }
}
