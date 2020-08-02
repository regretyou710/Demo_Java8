package tw.com.bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

	public static List<Employee> getEmployees() {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1001, "張三豐", 34, 6000.38));
		list.add(new Employee(1002, "周芷若", 12, 9872.25));
		list.add(new Employee(1003, "小昭", 33, 3000.82));
		list.add(new Employee(1004, "張翠山", 26, 7657.73));
		list.add(new Employee(1005, "張無忌", 65, 15555.61));
		list.add(new Employee(1006, "趙敏", 42, 7102.36));
		list.add(new Employee(1007, "金毛獅王", 26, 4333.19));
		list.add(new Employee(1008, "白眉鷹王", 35, 2500.48));
		return list;
	}
}
