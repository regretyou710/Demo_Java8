package tw.com.date;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

import org.junit.Test;

/*
 * jdk1.8日期時間API操作:java.time類
 */
public class Demo03 {

	// localDate、localTime、localDateTime的使用
	@Test
	public void test01() {
		// now():取得當前日期、時間、日期時間
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);

		// of():設置指定的年、月、日、時、分、秒，沒有偏移量
		LocalDateTime localDateTime = LocalDateTime.of(2020, 2, 12, 6, 3, 30);
		System.out.println(localDateTime);

		System.out.println();

		// getXXX():取得相關屬性
		System.out.println(localDateTime.getDayOfMonth());
		System.out.println(localDateTime.getDayOfWeek());
		System.out.println(localDateTime.getMonth());
		System.out.println(localDateTime.getMonthValue());
		System.out.println(localDateTime.getMinute());

		// withXXX():設置相關屬性。體現不可變性
		LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(15);
		localDateTime2 = localDateTime2.withHour(20);
		System.out.println("設置前:" + localDateTime);
		System.out.println("設置後:" + localDateTime2);

		// plusXXX():加
		LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
		System.out.println("設置前:" + localDateTime);
		System.out.println("設置後:" + localDateTime3);

		// minusXXX():減
		LocalDateTime localDateTime4 = localDateTime.minusDays(5);
		System.out.println("設置前:" + localDateTime);
		System.out.println("設置後:" + localDateTime4);
	}

	// Instant使用:類似java.util.Date類
	@Test
	public void test02() {
		// now():取得本初子午線對應的標準時間
		Instant now = Instant.now();
		System.out.println(now);

		// 添加時間的偏移量
		OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
		System.out.println(offsetDateTime);

		// toEpochMilli():取得自1970年1月1日0時0分0秒(UTC)開始的毫秒數
		long epochMilli = now.toEpochMilli();
		System.out.println(epochMilli);

		// ofEpochMilli():透過給定的毫秒數，獲取Instant實例。似Date(Long milli)
		@SuppressWarnings("static-access")
		Instant ofEpochMilli = now.ofEpochMilli(1596519247539L);
		System.out.println(ofEpochMilli);
	}

	// DateTimeFormatter使用:格式化或解析時間、日期
	@Test
	public void test03() {
		// 預定義的標準格式
		DateTimeFormatter isoLocalDateTime = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		// 格式化:日期->字串
		String dateTime = isoLocalDateTime.format(LocalDateTime.now());
		System.out.println(dateTime);
		// 解析:字串->日期
		TemporalAccessor parse = isoLocalDateTime.parse("2020-08-04T14:08:23.781");
		System.out.println(parse);

		System.out.println();

		// 本地化相關的格式
		// ① ofLocalizedDateTime()
		DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		String str1 = formatter1.format(LocalDateTime.now());
		System.out.println(str1);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
		String str2 = formatter2.format(LocalDateTime.now());
		System.out.println(str2);
		DateTimeFormatter formatter3 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
		String str3 = formatter3.format(LocalDateTime.now());
		System.out.println(str3);
		// ② ofLocalizedDate()
		DateTimeFormatter formatter4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		String str4 = formatter4.format(LocalDate.now());
		System.out.println(str4);

		System.out.println();

		// 自定義的格式
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String str = ofPattern.format(LocalDateTime.now());
		System.out.println(str);
		//解析
		TemporalAccessor parse2 = ofPattern.parse("2020-08-04 02:24:31");
		System.out.println(parse2);
	}
}
