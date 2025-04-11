package system_design.low_level_design.solid_principles.InterfaceSegregationPrinciple.ISPCompliant.AdaptorPattern;

import java.util.List;

public interface IMenu {

	List<FOODITEMS> getVegetarianItems();

	List<FOODITEMS> getNonVegetarianItems();

}
