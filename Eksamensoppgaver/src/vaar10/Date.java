package vaar10;

public class Date {

	private int day, month, year;
	
	public Date(int day, int month, int year) {
		check(day, month, year);
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && (year % 400 == 0 || year % 100 != 0));
	}
	
	private int numberOfDays(int month, int year) {
		switch (month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
		case 4: case 6: case 9: case 11: return 30;
		case 2: return (isLeapYear(year) ? 29 : 28);
		}
		return -1;
	}
	
	private void check(int day, int month, int year) {
		if (day < 1 || day > numberOfDays(month, year)) {
			throw new IllegalArgumentException("day is illegal:" + day);
		}
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("Month is illegal:" + month);
		}
	}
	
	public int getDay() {
		return day;
	}
	
	public void setDay(int day) {
		check(day, month, year);
		this.day = day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		check(day, month, year);
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		check(day, month, year);
		this.year = year;
	}
	
	public void setNextDay(Date d) {
		int numberOfDays = numberOfDays(d.month, d.year);
		if (d.day == numberOfDays) {
			if (d.month == 12) {
				d.setDay(1);
				d.setMonth(1);
				d.setYear(d.year + 1);
			} 
			else {
				d.setDay(1);
				d.setMonth(d.month + 1);
			}
		} 
		else {
			d.setDay(d.day + 1);
			d.setMonth(d.month + 1);
		}
	}
	
	public void setPreviousDay(Date d) {
		if (d.day == 1) {
			if (d.month == 1) {
				d.setMonth(12);
				d.setYear(d.year - 1);
				d.setDay(numberOfDays(d.month, d.year));
			}
			else {
				d.setMonth(d.month - 1);
				d.setDay(numberOfDays(d.month, d.year));
			}
		}
		else {
			d.setDay(d.day - 1);
		}
	}
	
	public static void main(String[] args) {
		Date d = new Date(30,4,1991);
		
		System.out.println(d.getDay());
		System.out.println(d.getMonth());
		System.out.println(d.getYear());
		System.out.println(d.isLeapYear(d.getYear()));
		System.out.println("im satisfied with this");
		d.setNextDay(d);
		System.out.println(d.getDay());
		System.out.println(d.getMonth());
	}
	 
}















