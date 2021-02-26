package cse3040ex1904;

import java.util.TreeSet;

class Person implements Comparable<Person> {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name + ":" + age;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person tmp = (Person) obj;
			return name.equals(tmp.name) && age == tmp.age;
		}
		return false;
	}

	public int hashCode() {
		return (name + age).hashCode();
	}

	public int compareTo(Person p) {//TreeSet은 크기 비교가 가능해야함
		if (this.name.compareTo(p.name)!=0)
			return this.name.compareTo(p.name);
		return (this.age<p.age)?-1:((this.age==p.age)?0:1);
	}
}

public class Ex19_04 {

	public static void main(String[] args) {
		TreeSet<Person> set = new TreeSet<>();
		set.add(new Person("David", 10));
		set.add(new Person("Javid", 15));
		set.add(new Person("Aavid", 12));
		set.add(new Person("Bavid", 9));
		set.add(new Person("David", 36));
		set.add(new Person("David", 10));
		set.add(new Person("Iavid", 10));
		System.out.println(set);
	}

}
