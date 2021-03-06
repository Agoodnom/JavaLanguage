package cse3040ex1202;

class Employee {
	private String name;
	protected int salary;

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public int getSalary() {
		return this.salary;
	}

	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if (otherObject == null)
			return false;
		if (getClass() != otherObject.getClass())
			return false;
		Employee other = (Employee) otherObject;
		return (this.name.equals(other.name) && this.salary == other.salary);
	}

	public int hashCode() {
		return this.name.hashCode() + salary;
	}

}

public class Ex12_02 {
	public static void main(String[] args) {
		Employee e1 = new Employee(new String("John"), 50000);
		Employee e2 = new Employee(new String("John"), 50000);
		System.out.println(e1.equals(e2));
		System.out.println(e1.hashCode() == e2.hashCode());
		System.out.println(e1.hashCode() + " " + e2.hashCode());
	}
}