package testsuite;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.testng.annotations.Test;

public class DateTimeHandle {
	// 1. Lấy tháng tiếp theo từ tháng hiện tại theo định dạng "October 2023"
	@Test
	public void getNext1MonthFromCurrentMonth1() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentMonth = df.format(calendar.getTime());
		System.out.println("current Month: " + currentMonth);

		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
		String nextMonth = df.format(calendar.getTime());
		System.out.println("NextMonth from curent month: " + nextMonth);
		// return nextMonth;
	}

	@Test
	// 2. Lấy tháng hiện tại theo định dạng "September 2023"
	public void getCurrentMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("MMMM yyyy");
		String currentMonth = df.format(calendar.getTime());
		System.out.println("currentMonthAsString: " + currentMonth);
		// return currentMonth;
	}

	@Test
	// 3. Lấy ngày tháng năm hiện tại
	public void getCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		// calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH));
		String currentdateTime = df.format(calendar.getTime());
		System.out.println("Current day - month - year: " + currentdateTime);
	}

	@Test
	// 4. Lấy 7 ngày tiếp theo từ ngày hiện tại
	public void getNext7DaysOfCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + 7);
		String next7Days = df.format(calendar.getTime());
		System.out.println("Next 7 days from current day: " + next7Days);
		// return next7Days;
	}

	@Test
	// Lấy tuần hiện tại theo định dạng: Dec 24 - 30, 2023, dùng cho case chọn hiển thị theo Week
	public void getWeekWithSpecialFormat() {
		// Get calendar set to current date and time
		Calendar c = GregorianCalendar.getInstance();
		// Set the calendar to monday of the current week
		c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		System.out.println("Current week = " + Calendar.DAY_OF_WEEK);
		// Print dates of the current week starting on Monday
		SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
		String startDate = "", endDate = "";
		startDate = df.format(c.getTime());
		c.add(Calendar.DATE, 6);
		endDate = df.format(c.getTime());
		System.out.println("Start Date = " + startDate);
		// cắt chuỗi endDate để chỉ lấy ra ngày
		System.out.println("Day of end Date = " + endDate.subSequence(4, 6));
		String expected = new StringBuilder().append(startDate.substring(0, 6)).append(" - ")
				.append(endDate.subSequence(4, 6))
				.append(startDate.substring(6, 12)).toString();
		System.out.println("Expected weekWithSpecialFormat: " + expected);
	}
}
