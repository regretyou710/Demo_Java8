package tw.com.date;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/*
 * Calendar類操作
 */
public class Demo02 {

	@Test
	public void test01() {
		// 因為Calendar為抽象類，透過getInstance()取得實例
		Calendar calendar = Calendar.getInstance();

		// 常用方法:
		// 取得當前月份第n天
		int days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.printf("當前月份第%d天\r\n", days);

		// 設置當前月份為第n天
		calendar.set(Calendar.DAY_OF_MONTH, 15);
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.printf("當前月份第%d天\r\n", days);

		// 當前月份為加n天
		calendar.add(Calendar.DAY_OF_MONTH, 5);
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.printf("當前月份第%d天\r\n", days);

		// 當前月份為減n天
		calendar.add(Calendar.DAY_OF_MONTH, -5);
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.printf("當前月份第%d天\r\n", days);
		
		//Calendar類對應Date類
		Date date = calendar.getTime();
		System.out.println(date);
		
		//Date類對應Calendar類
		Date now= new Date();
		calendar.setTime(now);
		days = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.printf("當前月份第%d天\r\n", days);
	}
}
