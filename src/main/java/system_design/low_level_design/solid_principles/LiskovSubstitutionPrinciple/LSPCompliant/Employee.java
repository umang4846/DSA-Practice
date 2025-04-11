package system_design.low_level_design.solid_principles.LiskovSubstitutionPrinciple.LSPCompliant;

public abstract class Employee implements IEmployee {

	private Integer id;
	private String name;

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
