package tw.com.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.junit.Test;

import tw.com.bean.Employee;
import tw.com.bean.EmployeeData;

/*
 *  Stream的中止操作:匹配與查找
 */
public class Demo05 {

	// allMatch(Predicate p):檢查是否匹配所有元素
	// 是否所有員工的年齡都大於18，所有年齡都大於18才返回true
	@Test
	public void test01() {
		List<Employee> employees = EmployeeData.getEmployees();
		boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
		System.out.println(allMatch);
	}

	// anyMatch(Predicate p):檢查是否至少匹配一個元素
	// 是否存在員工的薪資大於10000，只要有一個元素匹配就返回true
	@Test
	public void test02() {
		List<Employee> employees = EmployeeData.getEmployees();
		boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
		System.out.println(anyMatch);
	}

	// noneMatch(Predicate p):檢查是否沒有匹配元素
	// 是否員工姓"張"，如果存在"張"返回false
	@Test
	public void test03() {
		List<Employee> employees = EmployeeData.getEmployees();

		// boolean noneMatch = employees.stream().noneMatch(e ->
		// e.getName().substring(0,1).equals("張"));
		// boolean noneMatch = employees.stream().noneMatch(e ->
		// e.getName().startsWith("張"));

		boolean noneMatch = employees.stream().noneMatch(e -> e.getName().contains("張"));
		System.out.println(noneMatch);
	}

	// findFirst():返回第一個元素
	@Test
	public void test04() {
		List<Employee> employees = EmployeeData.getEmployees();
		Optional<Employee> findFirst = employees.stream().findFirst();
		System.out.println(findFirst);
	}

	// findAny():返回任一元素
	@Test
	public void test05() {
		List<Employee> employees = EmployeeData.getEmployees();

		// 順序流:從集合第一個元素開始輸出
		Optional<Employee> findAny1 = employees.stream().findAny();
		System.out.println(findAny1);

		// 並行流:
		Optional<Employee> findAny2 = employees.parallelStream().findAny();
		System.out.println(findAny2);
	}

	// count():返回流中元素總個數
	@Test
	public void test06() {
		List<Employee> employees = EmployeeData.getEmployees();
		long count = employees.stream().filter(e -> e.getSalary() > 5000).count();
		System.out.println(count);
	}

	// max(Comparator c):
	// 返回最高薪資
	@Test
	public void test07() {
		List<Employee> employees = EmployeeData.getEmployees();
		Stream<Double> mapStream = employees.stream().map(e -> e.getSalary());

		// Optional<Double> maxOpt = mapStream.max((e1, e2) ->
		// Double.compare(e1, e2));
		Optional<Double> maxOpt = mapStream.max(Double::compare);

		System.out.println(maxOpt);

	}

	// min(Comparator c):
	// 返回最低薪資的"員工"
	@Test
	public void test08() {

		new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.getSalary(), o2.getSalary());
			}
		};

		

		List<Employee> employees = EmployeeData.getEmployees();

		Stream<Employee> stream = employees.stream();

		// 因為是對員工物件進行薪資的比較規則所以在min()中使用方法引用會失敗
		Optional<Employee> minOpt = stream.min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
		stream.min(Double::compare);
		System.out.println(minOpt);
	}

	// forEach(Consumer):內部迭代
	@Test
	public void test09() {
		List<Employee> employees = EmployeeData.getEmployees();

		// 這裡的forEach(Consumer)指的是在stream中的終止方法
		employees.stream().forEach(System.out::print);

		System.out.println();

		// 這裡的forEach(Consumer)指的是集合中的迭代方法
		employees.forEach(System.out::print);
	}
}
