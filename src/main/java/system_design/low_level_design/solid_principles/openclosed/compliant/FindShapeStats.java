package system_design.low_level_design.solid_principles.openclosed.compliant;

public class FindShapeStats {

	private Shape shape;

	public Double getArea() {
		return shape.getArea();
	}

	public Double getPerimeter() {
		return shape.getPerimeter();
 	}
}
