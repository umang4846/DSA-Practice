package system_design.low_level_design.solid_principles.LiskovSubstitutionPrinciple.LSPViolated;

import java.util.List;

public interface IEmployee {

	Double calculateBonus();

	Double getSalary();

	List<Perks> getPerks();

}
