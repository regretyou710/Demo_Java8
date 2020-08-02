package tw.com.stream;

import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import tw.com.bean.Employee;
import tw.com.bean.EmployeeData;

/*
 * Stream的中間操作:篩選與切片
 */
public class Demo02 {

	// filter(Predicate p):從流中排除某些元素
	// 查詢員工表中薪資大於7000的員工訊息
	@Test
	public void test01() {
		List<Employee> list = EmployeeData.getEmployees();
		Stream<Employee> stream = list.stream();
		stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);
	}

	//limit(n)截斷流:使其元素不超過給定數量
	@Test
	public void test02() {
		List<Employee> list = EmployeeData.getEmployees();
		Stream<Employee> stream = list.stream();
		stream.limit(3).forEach(System.out::println);
	}

	//skip(n)跳過元素:返回一個扔掉了前n個元素的流;若流中元素不足n個，則返回一個空流。
	//與limit(n)互補
	@Test
	public void test03() {
		List<Employee> list = EmployeeData.getEmployees();
		Stream<Employee> stream = list.stream();
		stream.skip(3).forEach(System.out::println);
	}

	//distinct()生成:透過流所生成元素的hashCode()和eqals()去除重複元素
	@Test
	public void test04() {
		List<Employee> list = EmployeeData.getEmployees();
		list.add(new Employee(1009, "張無忌", 65, 5555.61));
		list.add(new Employee(1010, "張無忌", 65, 5555.61));
		list.add(new Employee(1010, "張無忌", 22, 5555.61));
		list.add(new Employee(1010, "張無忌", 65, 7777.11));
		list.add(new Employee(1010, "張無忌", 65, 5555.61));
		list.add(new Employee(1010, "張無忌", 65, 5555.61));
		list.add(new Employee(1010, "張無忌", 65, 5555.61));
		list.add(new Employee(1010, "張無忌", 65, 5555.61));
		System.out.println(list);
		
		System.out.println("--------------");
		
		Stream<Employee> stream = list.stream();
		stream.distinct().forEach(System.out::print);
	}
}
