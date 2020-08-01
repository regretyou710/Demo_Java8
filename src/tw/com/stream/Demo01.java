package tw.com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import tw.com.bean.Employee;
import tw.com.bean.EmployeeData;

/*
 * Stream的實例化
 * 
 */
public class Demo01 {

	// 創建Stream方式一:透過集合
	@Test
	public void test01() {
		List<Employee> employees = EmployeeData.getEmployees();

		// 返回一個順序流
		Stream<Employee> stream = employees.stream();

		// 返回一個並行流
		Stream<Employee> parallelStream = employees.parallelStream();

	}

	// 創建Stream方式二:透過陣列
	@Test
	public void test02() {
		int[] arr = { 1, 2, 3, 4, 5 };
		IntStream stream = Arrays.stream(arr);

		Employee e1 = new Employee(1001, "Tim");
		Employee e2 = new Employee(1002, "Tom");
		Employee[] emps = new Employee[] { e1, e2 };
		Stream<Employee> stream2 = Arrays.stream(emps);
	}

	// 創建Stream方式三:透過Stream的of()
	@Test
	public void test03() {
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
	}

	// 創建Stream方式四:創建無限流
	@Test
	public void test04() {
		// 迭代
		//遍歷前十個偶數
		Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
		
		//生成
		//生成十個隨機數
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
	}
}
