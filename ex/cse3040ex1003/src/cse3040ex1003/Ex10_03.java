package cse3040ex1003;

class Employee{
	private String name;
	private int salary;
	public Employee() {
		this.name = "NoName";
		this.salary = 0;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return this.salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}

class Manager extends Employee{
	private int bonus;
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public int getSalary() {
		return super.getSalary() + bonus;
	}
}

public class Ex10_03 {

	public static void main(String[] args) {
		Manager m = new Manager();
		m.setName("ju");
		m.setSalary(1000);
		m.setBonus(100);
		System.out.println(m.getName()+" "+m.getSalary());
	}

}
