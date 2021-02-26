package homework2;

class Point {
	private double arr[];

	public Point(double[] arr) {
		int length = arr.length;
		this.arr = new double[length];
		for (int i = 0; i < length; i++) {
			this.arr[i] = arr[i];
		}
	}

	public int size() {
		return this.arr.length;
	}

	public double arr(int i) {
		return arr[i];
	}
}

class EuclideanDistance {
	public static double getDist(Point p1, Point p2) {
		if (p1.size() != p2.size()) {
			return -1;
		} else {
			double d = 0;
			for (int i = 0; i < p1.size(); i++) {
				d += Math.pow(p1.arr(i) - p2.arr(i), 2);
			}
			d = Math.sqrt(d);
			return d;
		}
	}
}

class ManhattanDistance {
	public static double getDist(Point p1, Point p2) {
		if (p1.size() != p2.size()) {
			return -1;
		} else {
			double d = 0;
			for (int i = 0; i < p1.size(); i++) {
				d += Math.abs(p1.arr(i) - p2.arr(i));
			}
			return d;
		}
	}
}

public class Problem09 {
	public static void main(String[] args) {
		Point p1 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p2 = new Point(new double[] { 4.0, 5.0, 6.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p1, p2));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p1, p2));
		Point p3 = new Point(new double[] { 1.0, 2.0, 3.0 });
		Point p4 = new Point(new double[] { 4.0, 5.0 });
		System.out.println("Euclidean Distance: " + EuclideanDistance.getDist(p3, p4));
		System.out.println("Manhattan Distance: " + ManhattanDistance.getDist(p3, p4));
	}
}