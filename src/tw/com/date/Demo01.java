package tw.com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

/*
 * jdk1.8之前的日期時間操作
 * ① System類中的currentTimeMillis()
 * ② java.util.Date和子類java.sql.Date
 * ③ SimpleDateFormat
 * ④ Calendar
 */
public class Demo01 {

	@Test
	public void test01() throws ParseException {
		// 創建SimpleDateFormat物件:使用預設建構式
		SimpleDateFormat sdf = new SimpleDateFormat();

		// 格式化:日期->字串
		Date date = new Date();
		System.out.println(date);

		String format = sdf.format(date);
		System.out.println(format);

		// 解析:格式化逆過程，字串->日期
		String str = "2020/8/3 下午 9:32";
		Date date1 = sdf.parse(str);
		System.out.println(date1);

		System.out.println();

		// 按照指定格式格式化
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format2 = sdf2.format(date);
		System.out.println(format2);

		// 解析:要求字串必須符合SimpleDateFormat識別的格式(建構式參數)，否則拋異常
		String str2 = "2020-08-03 09:41:10";
		Date date2 = sdf2.parse(str2);
		System.out.println(date2);
	}

	// 將字串"2020-12-31"轉換成java.sql.Date
	@Test
	public void test02() throws ParseException {
		String birth = "2020-12-31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date utilDate = sdf.parse(birth);
		System.out.println(utilDate);

		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println(sqlDate);
	}

	public int countDayUtil(String startDate, String endDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		int days = 0;
		try {
			long start = sdf.parse(startDate).getTime();
			long end = sdf.parse(endDate).getTime();
			days = (int) ((end - start) / (1000 * 60 * 60 * 24) + 1);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return days;
	}
	

	@Test
	public void test03() {
		// 範例:"三天打漁兩天曬網"，請問:在1950-01-01開始進行，在2021-06-30這天是打漁還是曬網?
		int days = countDayUtil("1950-01-01", "2021-06-30");
		// System.out.println(days);
		switch (days % 5) {
		case 1:
		case 2:
		case 3:
			System.out.println("打漁");
			break;
		case 4:
		case 0:
			System.out.println("曬網");
			break;
		}
	}
}
