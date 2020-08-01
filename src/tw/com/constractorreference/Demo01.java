package tw.com.constractorreference;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

import tw.com.bean.Employee;

/*
 * 建構式引用
 * 說明:和方法引用類似，函數式介面的抽象方法參數列表和建構式的參數列表一致
 * 	   抽象方法的返回值類型即為建構式所屬類的類型
 * 
 * 陣列引用
 * 說明:把陣列看作是一個特殊的類，寫法語建構式引用一致
 */
public class Demo01 {

	// Supplier中的T get()
	// Employee的空參建構式:Employee()
	// get()對應Employee()，new Employee()的時候相當於返回了T類型
	@Test
	public void test01() {
		Supplier<Employee> supplier1 = () -> new Employee();
		System.out.println(supplier1.get());

		System.out.println("------------------");

		Supplier<Employee> supplier2 = Employee::new;
		System.out.println(supplier2.get());
	}

	// Funcation中的 R apply(T t)
	// Employee的建構式:Employee(int id)
	@Test
	public void test02() {
		Function<Integer, Employee> function1 = id -> new Employee(id);
		Employee emp1 = function1.apply(1001);
		System.out.println(emp1);

		System.out.println("------------------");

		Function<Integer, Employee> function2 = Employee::new;
		Employee emp2 = function2.apply(1002);
		System.out.println(emp2);
	}

	// BiFuncation中的R apply(T t,U u)
	// Employee的建構式:Employee(int id, String name)
	@Test
	public void test03() {
		BiFunction<Integer, String, Employee> biFunction1 = (id, name) -> new Employee(id, name);
		Employee emp1 = biFunction1.apply(1003, "Jim");
		System.out.println(emp1);

		System.out.println("------------------");

		BiFunction<Integer, String, Employee> biFunction2 = Employee::new;
		Employee emp2 = biFunction2.apply(1004, "Tim");
		System.out.println(emp2);
	}

	// 陣列引用
	// Funcation中的 R apply(T t)
	// String[]的建構式:new String[]
	@Test
	public void test04() {
		Function<Integer, String[]> function1 = length -> new String[length];
		String[] arr1 = function1.apply(5);
		System.out.println(Arrays.toString(arr1));

		System.out.println("------------------");

		Function<Integer, String[]> function2 = String[]::new;
		String[] arr2 = function2.apply(7);
		System.out.println(Arrays.toString(arr2));
	}
}
