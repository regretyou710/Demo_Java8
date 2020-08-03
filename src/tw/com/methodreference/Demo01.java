package tw.com.methodreference;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import tw.com.bean.Employee;

/*
 * 方法引用操作
 * 方法引用的要求:要求介面中的抽象方法的參數列表和返回值類型與方法引用的參數列表和返回值類型相同(針對情況一和情況二)
 */
public class Demo01 {
	
	// 情況一: 物件(對象)::實例方法
	// Consumer中的void accept(T t)
	// PrintStream中的void println(T t)
	@Test
	public void test01() {
		Consumer<String> consumer1 = t -> System.out.println(t);
		consumer1.accept("引用方法練習一");

		System.out.println("-----------------");

		PrintStream ps = System.out;
		Consumer<String> consumer2 = ps::println;
		consumer2.accept("引用方法練習一");
	}

	// Supplier中的T get()
	// Employee中的String getName()
	@Test
	public void test02() {
		Employee emp = new Employee(1001, "Tom", 22, 3355.6);
		Supplier<String> supplier1 = () -> emp.getName();
		System.out.println(supplier1.get());

		System.out.println("-----------------");

		Supplier<String> supplier2 = emp::getName;
		System.out.println(supplier2.get());
	}

	// 情況二: 類::靜態方法
	// Comparator中的 int compare(T t1, T t2)
	// Integer中的 int compare(T t1, T t2)
	@Test
	public void test03() {
		Comparator<Integer> comparator1 = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(comparator1.compare(15, 10));

		System.out.println("-----------------");

		Comparator<Integer> comparator2 = Integer::compare;
		System.out.println(comparator2.compare(5, 10));
	}

	// Funcation中的R apply(T t)
	// Math中的Long round(Double d)
	@Test
	public void test04() {
		Function<Double, Long> function1 = d -> Math.round(d);
		System.out.println(function1.apply(5.5));

		System.out.println("-----------------");

		Function<Double, Long> function2 = Math::round;
		System.out.println(function2.apply(5.2));
	}

	// 情況三: 類::實例方法
	// Comparator中的 int compare(T t1, T t2)
	// String中的 int t1.compareTo(t2)
	// compare的第一個參數作為compareTo的調用者
	@Test
	public void test05() {
		Comparator<String> comparator1 = (t1, t2) -> t1.compareTo(t2);
		System.out.println(comparator1.compare("abc", "abd"));

		System.out.println("-----------------");

		Comparator<String> comparator2 = String::compareTo;
		System.out.println(comparator2.compare("abe", "abj"));
	}

	// BiPredicate中的boolean test(T t1,T t2)
	// String中的boolean t1.equals(t2)
	@Test
	public void test06() {
		BiPredicate<String, String> biPredicate1 = (s1, s2) -> s1.equals(s2);
		System.out.println(biPredicate1.test("AA", "AA"));

		System.out.println("-----------------");

		BiPredicate<String, String> biPredicate2 = String::equals;
		System.out.println(biPredicate2.test("AB", "BA"));
	}

	// Funcation中的R apply(T t)
	// Employee中的 String getName()
	@Test
	public void test07() {
		Employee emp = new Employee(1001, "Tom", 22, 3355.6);
		
		Function<Employee, String> function1 = e -> e.getName();
		System.out.println(function1.apply(emp));
		
		System.out.println("-----------------");
		
		Function<Employee, String> function2 = Employee::getName;
		System.out.println(function2.apply(emp));
		
	}
}
