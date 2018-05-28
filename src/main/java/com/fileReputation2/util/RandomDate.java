package com.fileReputation2.util;

import java.util.GregorianCalendar;

public class RandomDate {
	public static GregorianCalendar getRandomDate(int start, int end) {
		GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(2016, 2018);
        gc.set(gc.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        System.out.println(gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
        return gc;
	}
	public static int randBetween(int start, int end) {
		return start + (int)Math.round(Math.random() * (end - start));
	}

}
