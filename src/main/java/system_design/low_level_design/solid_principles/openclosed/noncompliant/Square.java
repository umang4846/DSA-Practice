package system_design.low_level_design.solid_principles.openclosed.noncompliant;

public class Square implements Shape {

	private int side;

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
}
