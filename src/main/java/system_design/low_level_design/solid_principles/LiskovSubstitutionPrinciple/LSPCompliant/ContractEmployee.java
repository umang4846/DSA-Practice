package system_design.low_level_design.solid_principles.LiskovSubstitutionPrinciple.LSPCompliant;

public class ContractEmployee extends Employee {

	public ContractEmployee(Integer id, String name) {
		super(id, name);
	}

	@Override
	public Double getSalary() {
		return 25000d;
	}

}
