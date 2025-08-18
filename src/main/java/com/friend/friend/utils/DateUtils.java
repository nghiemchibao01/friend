package com.friend.friend.utils;

import java.time.LocalDate;
import  java.time.Period;

public class DateUtils {
	private DateUtils() {
		throw new UnsupportedOperationException("Utility class");
	}

	public static int calculateAge(LocalDate birthday) {
		if (birthday == null) return 0;
		return Period.between(birthday, LocalDate.now()).getYears();
	}
}
