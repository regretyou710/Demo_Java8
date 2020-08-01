package tw.com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Test;

/*
 * java提供了四大函數式介面
 * Consumer<T> void accept(T t)
 * Supplier<T> T get()
 * Function<T,R> R apply(T t)
 * Pradicate<T> boolean test(T t)
 */
public class Demo02 {

	@Test
	public void test01() {
		happyTime(200, new Consumer<Double>() {
			@Override
			public void accept(Double t) {
				System.out.println("唱歌吃飯花了" + t + "元");
			}
		});

		System.out.println("------------------------");

		happyTime(350, t -> System.out.println("唱歌吃飯花了" + t + "元"));
	}

	public void happyTime(double money, Consumer<Double> consumer) {
		consumer.accept(money);
	}

	@Test
	public void test02() {
		List<String> list = Arrays.asList("汽車","公車","腳踏車","郵輪","飛機","機車","捷運");
		
		List<String> filterString = filterString(list, new Predicate<String>() {
			@Override
			public boolean test(String t) {				
				return t.contains("車");
			}
		});
		System.out.println(filterString);
		
		System.out.println("------------------------");
		
		List<String> filterString2 = filterString(list,t->t.contains("車"));
		System.out.println(filterString2);
	}

	/**
	 * 根據給定的規則，過濾集合中的字串。此規則由Predicate的方法決定。
	 * 
	 * @param list
	 * @param predicate
	 * @return
	 */
	public List<String> filterString(List<String> list, Predicate<String> predicate) {
		ArrayList<String> arrList = new ArrayList<>();
		for (String str : list) {
			if (predicate.test(str)) {
				arrList.add(str);
			}
		}
		return arrList;
	}
}
