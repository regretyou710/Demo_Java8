package tw.com.optional;

import java.util.Optional;
import org.junit.Test;

import tw.com.bean.Boy;
import tw.com.bean.Girl;

/*
 * Optional類:為了在開發程式過程中避免空指針異常而創建。
 * 
 * 常用方法:
 * Optional.of(T t):建立一個Optional實例，t須非空。
 * Optional.empty():建立一個空的Optional實例。
 * Optional.ofNullable(T t):t可以為空。
 * get():如果調用對象包含值，返回該值，否則拋異常。
 * orElse(T t1)
 * isPresent():判斷是否包含對象
 */
public class Demo01 {

	// 如果of()參數為空，則拋空指針異常NullPointerException();
	@Test
	public void test01() {
		Girl girl = new Girl();
		girl = null;
		Optional<Girl> op = Optional.of(girl);

	}

	// 如果ofNullable()參數為空，不會拋空指針異常，會顯示Optional是空的實例
	@Test
	public void test02() {
		Girl girl = new Girl();
		girl = null;
		Optional<Girl> op = Optional.ofNullable(girl);
		System.out.println(op);
	}

	public String getGirlName(Boy boy) {
		return boy.getGirl().getName();
	}

	@Test
	public void test04() {
		Boy boy = new Boy();
		boy = null;
		String girlName = getGirlName(boy);
		System.out.println(girlName);
		// 1.因為Boy身上的Girl物件沒有實例，所以發生空指針異常
		// 2.因為Boy物件沒有實例，所以發生空指針異常
	}

	// 未使用Optional時，優化後的getGirlName()
	public String getGirlName2(Boy boy) {
		if (boy != null) {
			System.out.println("Boy不為空");
			Girl girl = boy.getGirl();
			if (girl != null) {
				System.out.println("Girl不為空");
				return girl.getName();
			}
		}
		return null;
	}

	@Test
	public void test05() {
		Boy boy = new Boy();
		boy = null;
		String girlName = getGirlName2(boy);
		System.out.println(girlName);
	}

	// 使用Optional時，優化後的getGirlName()
	// orElse(T t1):如果當前Optional內部封裝的t不是空，則返回內部的t;如果內部的t為空，則返回orElse()方法中的參數
	public String getGirlName3(Boy boy) {
		// boy傳遞進來有可能為空，所以使用Optional.ofNullable();
		Optional<Boy> boyOpt = Optional.ofNullable(boy);
		// 此時boy1一定非空
		Boy boy1 = boyOpt.orElse(new Boy(new Girl("周芷若")));
		Girl girl1 = boy1.getGirl();

		Optional<Girl> girlOpt = Optional.ofNullable(girl1);
		// 此時girl2一定非空
		Girl girl2 = girlOpt.orElse(new Girl("趙敏"));
		return girl2.getName();
	}

	@Test
	public void test06() {
		Boy boy = null;
		boy = new Boy();
		boy = new Boy(new Girl("小昭"));
		String girlName = getGirlName3(boy);
		System.out.println(girlName);
	}
}
