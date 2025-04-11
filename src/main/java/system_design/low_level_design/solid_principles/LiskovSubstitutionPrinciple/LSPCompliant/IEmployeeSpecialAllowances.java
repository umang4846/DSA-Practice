package system_design.low_level_design.solid_principles.LiskovSubstitutionPrinciple.LSPCompliant;

import java.util.List;

public interface IEmployeeSpecialAllowances {

	Double calculateBonus();

	List<Perks> getPerks();

}
