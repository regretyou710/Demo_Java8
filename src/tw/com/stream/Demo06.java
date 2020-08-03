package tw.com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

import org.junit.Test;

import tw.com.bean.Employee;
import tw.com.bean.EmployeeData;

/*
 *Stream的終止操作:歸約
 */
public class Demo06 {

	// reduce(T identity, BinaryOperator<T> accumulator):可以將流中元素反覆結合起來，得到一個值。返回T
	// identity：初始值(起始值)
	// 計算1-10自然數的總和
	@Test
	public void test01() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// new BinaryOperator<Integer>() {
		// @Override
		// public Integer apply(Integer t, Integer u) {
		// return t + u;
		// }
		// };

		// 方法一:
		// Integer sum = list.stream().reduce(0, (i1, i2) -> i1 + i2);

		// 方法二:
		// Integer sum = list.stream().reduce(0,(i1, i2) -> Integer.sum(i1,
		// i2));
		Integer sum = list.stream().reduce(0, Integer::sum);

		System.out.println(sum);
	}

	// reduce(BinaryOperator<T> accumulator):可以將流中元素反覆結合起來，得到一個值。返回Optional<T>
	// 計算公司所有員工薪資總和
	@Test
	public void test02() {
		List<Employee> employees = EmployeeData.getEmployees();
		Stream<Double> streamSalary1 = employees.stream().map(e -> e.getSalary());
		Optional<Double> sum1 = streamSalary1.reduce((s1, s2) -> s1 + s2);
		System.out.println(sum1);

		System.out.println("---------------");

		Stream<Double> streamSalary2 = employees.stream().map(Employee::getSalary);
		Optional<Double> sum2 = streamSalary2.reduce(Double::sum);
		System.out.println(sum2);
	}
}
