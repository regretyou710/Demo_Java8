package tw.com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import tw.com.bean.Employee;
import tw.com.bean.EmployeeData;

/*
 * Stream的中間操作:映射
 */
public class Demo03 {

	// map(Funcation f):接收一個函數作為參數，將元素轉換成其他形式或其取訊息，該函數會被應用到每個元素上，並將其映射成一個新的元素。
	// 獲取員工姓名長度大於3的資料
	@Test
	public void test01() {
		List<Employee> list = EmployeeData.getEmployees();
		Stream<Employee> stream = list.stream();

		// Stream<String> nameStream = stream.map(e->e.getName());
		Stream<String> nameStream = stream.map(Employee::getName);

		nameStream.filter(name -> name.length() > 3).forEach(System.out::println);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test02() {
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		ArrayList list2 = new ArrayList();
		list2.add(4);
		list2.add(5);
		list2.add(6);

		// 與map()操作類似
		// list1.add(list2);

		// 與flatMap()操作類似
		list1.addAll(list2);

		System.out.println(list1);
	}

	// 將字串的多個字元構成的集合轉換為對應的Stream的實例
	public static Stream<Character> fromStringToStream(String str) {
		ArrayList<Character> list = new ArrayList<>();
		for (Character character : str.toCharArray()) {
			list.add(character);
		}
		return list.stream();
	}

	// 使用map()方法將集合中的每個字串元素透過fromStringToStream()分別轉換為獨立字元並顯示
	@Test
	public void test04() {
		List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
		
		//---------------------------
		// 把list丟進fromStringToStream()方法依序返回會長這樣:[a,a],[b,b],[c,c],[d,d]他們都是Stream<Character>實例
		// 所以只做一次forEach()只會返回實例位址，還要在操作一次forEach()才能得到字元

		//只做一次等同下面3列操作:
		// Stream<Character> fromStringToStream = Demo03.fromStringToStream(list.get(0));
		// Stream<Stream<Character>> stream = Stream.of(fromStringToStream);
		// stream.forEach(System.out::println);		
		//---------------------------
		
		// list.stream().map(str->Demo03.fromStringToStream(str));
		Stream<Stream<Character>> mapStream = list.stream().map(Demo03::fromStringToStream);

		mapStream.forEach(stream -> stream.forEach(System.out::println));
	}
	

	// flatMap(Funcation f):接收一個函數作為參數，將流中的每個值都換成另一個流，然後把所有流連接成一個流。	
	@Test
	public void test05() {
		List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
		// 使用flatMap()操作只需要做一次forEach()
		Stream<Character> mapStream = list.stream().flatMap(Demo03::fromStringToStream);
		mapStream.forEach(System.out::println);
	}
}
