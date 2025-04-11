package system_design.low_level_design.solid_principles.InterfaceSegregationPrinciple.ISPCompliant.AdaptorPattern;

public class MenuManager {

	public static void main(String[] args) {

		CombinedMenu combinedMenu = new CombinedMenu();
		IVegetarianMenu tasteOfIndia = new VegMenuAdapter(combinedMenu);
		tasteOfIndia.getVegetarianItems();

	}

}
