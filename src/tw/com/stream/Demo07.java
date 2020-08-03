package tw.com.stream;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import tw.com.bean.Employee;
import tw.com.bean.EmployeeData;

/*
 * Stream的終止操作:收集
 */
public class Demo07 {

	// collect(Collector c):將流轉換為其他形式。接收一個Collector介面的實作，用於給Stream中元素做總匯的方法
	// 查詢薪水大於6000的員工，結果返回一個list或set
	@Test
	public void test01() {
		List<Employee> employees = EmployeeData.getEmployees();
		Stream<Employee> filter = employees.stream().filter(e -> e.getSalary() > 6000);
		List<Employee> collect = filter.collect(Collectors.toList());
		collect.forEach(System.out::print);
		
		System.out.println();
		
		List<Employee> employees2 = EmployeeData.getEmployees();
		Stream<Employee> filter2 = employees2.stream().filter(e -> e.getSalary() > 6000);
		Set<Employee> collect2 = filter2.collect(Collectors.toSet());
		collect2.forEach(System.out::print);
	}
}
