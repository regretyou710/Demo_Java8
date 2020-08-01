package tw.com.lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

/*
 * Lambda表達式舉例
 * Lambda表達式的本質:作為函數式介面的實例
 */
public class Demo01 {

	// 語法格式一:無參數，無返回值
	@Test
	public void test01() {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				System.out.println("Lambda語法格式一");
			}
		};
		runnable.run();

		System.out.println("---------------");

		Runnable runnable2 = () -> {
			System.out.println("Lambda語法格式一");
		};
		runnable2.run();
	}

	// 語法格式二:一個參數，無返回值
	@Test
	public void test02() {

		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);

			}
		};
		consumer.accept("Lambda語法格式二");

		System.out.println("---------------");

		Consumer<String> consumer2 = (String t) -> {
			System.out.println(t);
		};
		consumer2.accept("Lambda語法格式二");

	}

	// 語法格式三:數據類型可以省略，可以由編譯器推斷得出，稱為類型推斷
	@Test
	public void test03() {
		Consumer<String> consumer1 = (String t) -> {
			System.out.println(t);
		};
		consumer1.accept("Lambda語法格式二");

		System.out.println("---------------");

		Consumer<String> consumer2 = (t) -> {
			System.out.println(t);
		};
		consumer2.accept("Lambda語法格式二");
	}

	@Test
	public void test04() {
		// 類型推斷
		ArrayList<String> arrayList = new ArrayList<>();

		// 類型推斷
		int[] arr1 = new int[] { 1, 2, 3 };
		int[] arr2 = { 1, 2, 3 };
	}

	// 語法格式四:只有一個參數時，參數的小括弧可以省略
	@Test
	public void test05() {
		Consumer<String> consumer1 = (String t) -> {
			System.out.println(t);
		};
		consumer1.accept("Lambda語法格式二");

		System.out.println("---------------");

		Consumer<String> consumer2 = t -> {
			System.out.println(t);
		};
		consumer2.accept("Lambda語法格式二");
	}

	// 語法格式五:執行兩個或以上的參數，多條執行語句，並且有返回值
	@Test
	public void test06() {
		Comparator<Integer> comparator1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				System.out.println(o1);
				System.out.println(o2);
				return o1.compareTo(o2);
			}
		};
		System.out.println(comparator1.compare(5, 10));

		System.out.println("---------------");

		Comparator<Integer> comparator2 = (o1, o2) -> {
			System.out.println(o1);
			System.out.println(o2);
			return o1.compareTo(o2);
		};
		System.out.println(comparator2.compare(15, 10));
	}

	// 語法格式六:方法體只有一條語句，return和大括弧可以省略
	@Test
	public void test07() {
		Comparator<Integer> comparator1 = (o1, o2) -> {
			return o1.compareTo(o2);
		};
		System.out.println(comparator1.compare(15, 10));

		System.out.println("---------------");

		Comparator<Integer> comparator2 = (o1, o2) -> o1.compareTo(o2);

		System.out.println(comparator2.compare(15, 10));
	}

	@Test
	public void test08() {
		Consumer<String> consumer1 = t -> {
			System.out.println(t);
		};
		consumer1.accept("Lambda語法格式二");

		System.out.println("---------------");

		Consumer<String> consumer2 = t -> System.out.println(t);

		consumer2.accept("Lambda語法格式二");
	}
}
