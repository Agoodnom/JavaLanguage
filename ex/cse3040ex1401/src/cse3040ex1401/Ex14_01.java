package cse3040ex1401;

class A {
	public String toString() {
		return "class A Object";
	}
}

class B {
	public String toString() {
		return "class B Object";
	}
}

class C {
	public String toString() {
		return "class C Object";
	}
}

class Box<T> {
	T item;

	void setItem(T item) {
		this.item = item;
	}

	public T getItem() {
		return item;
	}
}

public class Ex14_01 {

	public static void main(String[] args) {
		Box<A> boxa = new Box<>();
		boxa.setItem(new A());
		Box<B> boxb = new Box<>();
		boxb.setItem(new B());
		Box<C> boxc = new Box<>();
		boxc.setItem(new C());

		System.out.println(boxa.getItem());
		System.out.println(boxb.getItem());
		System.out.println(boxc.getItem());
	}

}
