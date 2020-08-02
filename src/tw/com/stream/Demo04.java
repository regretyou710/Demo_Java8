package tw.com.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import tw.com.bean.Employee;
import tw.com.bean.EmployeeData;

/*
 * Stream的中間操作:排序
 * String和外覆類別都實現Comparable介面重寫compareTo(T t)方法
 * 但外覆類別重寫compareTo(T t)方法的內容是去調用自定義的compare(T t1,T t2)靜態方法，其內容也是撰寫自然排序
 * 所以外覆類別身上都帶有compareTo(T t)<非靜態>和compare(T t1,T t2)<靜態>方法
 * 
 * compareTo(T t):調用此方法的物件和參數進行比較
 */
public class Demo04 {

	// sorted():自然排序
	@Test
	public void test01() {
		List<Integer> list = Arrays.asList(45, 2, 76, 131, 0, -14, -6);
		list.stream().sorted().forEach(System.out::println);

		// 拋異常，原因：Employee沒有實現Comparable介面
		// List<Employee> employees = EmployeeData.getEmployees();
		// employees.stream().sorted().forEach(System.out::println);
	}

	// sorted(Comparator com):自訂排序
	// 如果想讓自定義類進行排序但又沒實作Comparable介面，就得使用Comparator
	@Test
	public void test02() {
		List<Employee> employees = EmployeeData.getEmployees();

		employees.stream().sorted((e1, e2) -> {
			int ageValue = Integer.compare(e1.getAge(), e2.getAge());
			if (ageValue != 0) {
				return ageValue;
			} else {
				return Double.compare(e1.getSalary(), e2.getSalary());
			}
		}).forEach(System.out::print);
	}

}
