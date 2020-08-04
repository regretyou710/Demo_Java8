package tw.com.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

public class Demo01 {
	public static void main(String[] args) {
		Person p = new Student();
		p.walk();

		@SuppressWarnings("deprecation")
		Date date = new Date(2020, 1, 1);
		System.out.println(date);

		@SuppressWarnings("unused")
		int i = 0;
	}

	// 證明修飾的Annotation將具有繼承性
	@SuppressWarnings("rawtypes")
	@Test
	public void test01() {
		Class clazz = Student.class;
		Annotation[] annot = clazz.getAnnotations();
		for (int i = 0; i < annot.length; i++) {
			System.out.println(annot[i]);
		}
	}
}

// jdk1.8之前的作法
// @AnnotactionDemo01B(value={@AnnotactionDemo01A(value="hi"),@AnnotactionDemo01A("abc")})

// 可重複註解:
@AnnotactionDemo01A(value = "hi")
@AnnotactionDemo01A(value = "abc")
class Person {
	private String name;
	private int age;

	@AnnotactionDemo01A("hello")
	public Person() {
		super();

	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public void walk() {
		System.out.println("人走路");
	}

	public void eat() {
		System.out.println("人吃飯");
	}
}

class Student extends Person {
	@Override
	public void walk() {
		System.out.println("學生走路");
	}

	public void show() {

	}
}

class Generic<@AnnotactionDemo01A T> {

	@SuppressWarnings("unused")
	public void show() throws @AnnotactionDemo01A RuntimeException {
		ArrayList<@AnnotactionDemo01A String> arrayList = new ArrayList<>();

		int i = (@AnnotactionDemo01A int) 100L;
	}
}