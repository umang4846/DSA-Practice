package system_design.low_level_design.solid_principles.openclosed.noncompliant;

public class FindShapeStats {

	private Shape shape;

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Double getArea() {

		if (shape instanceof Circle) {
			return 3.14 * ((Circle) shape).getRadius() * ((Circle) shape).getRadius();
		}
		else if (shape instanceof Square) {
			return ((Square) shape).getSide() * ((Square) shape).getSide() * 1.d;
		}
		else if (shape instanceof Rectangle) {
			return ((Rectangle) shape).getBreadth() * ((Rectangle) shape).getLength() * 1.d;
		}
		return null;
	}

	public Double getPerimeter() {
		// here as well instance of checks
		return null;
 	}
}
