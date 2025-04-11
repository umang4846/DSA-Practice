package system_design.low_level_design.solid_principles.InterfaceSegregationPrinciple.ISPCompliant.Redesign;

import java.util.ArrayList;
import java.util.List;


public class TasteOfIndia implements IVegetarianMenu {

	@Override
	public List<FOODITEMS> getVegetarianItems() {
		List<FOODITEMS> vegFood = new ArrayList<>();
		vegFood.add(FOODITEMS.DAL_MAKNI);
		vegFood.add(FOODITEMS.PANEER_PASANDA);
		return vegFood;
	}


}
