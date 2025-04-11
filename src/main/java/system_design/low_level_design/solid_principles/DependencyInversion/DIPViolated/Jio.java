package system_design.low_level_design.solid_principles.DependencyInversion.DIPViolated;

public class Jio {

	public void makeCall(int stdCode, int no){
		System.out.println("Making a call via jio network on "
						                   + stdCode + "-"+ no);
	}

}
