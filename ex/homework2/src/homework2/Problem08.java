package homework2;

abstract class Shape {
	abstract double area();
}

class Circle extends Shape {
	private double r;

	public Circle(double r) {
		this.r = r;
	}

	public double area() {
		double area;
		area = Math.PI * r * r;
		return area;
	}
}

class Square extends Shape {
	private double x;

	public Square(double x) {
		this.x = x;
	}

	public double area() {
		double area;
		area = x * x;
		return area;
	}
}

class Rectangle extends Shape {
	private double x, y;

	public Rectangle(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double area() {
		double area;
		area = x * y;
		return area;
	}
}

public class Problem08 {

	public static double sumArea(Shape[] arr) {
		int n = arr.length;
		double sum=0;
		for(int i=0;i<n;i++) {
			sum += arr[i].area();
		}
		
		return sum;
	}

	public static void main(String[] args) {
		Shape[] arr = { new Circle(5.0), new Square(4.0), 
				new Rectangle(3.0, 4.0), new Square(5.0) };
		System.out.println("Total area of the shapes is: " + sumArea(arr));
	}
}
