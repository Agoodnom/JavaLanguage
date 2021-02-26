package cse3040ex1102;

abstract class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public final String getName() {
		return name;
	}

	public abstract int getId();
}

class Student extends Person {
	int code;

	public Student(String name, int code) {
		super(name);
		this.code = code;
	}

	public int getId() {
		return code;
	}
}

public class Ex11_02 {

	public static void main(String[] args) {
		Person p = new Student("Fred", 1729);
		System.out.println(p.getName() + " " + p.getId());
	}

}
