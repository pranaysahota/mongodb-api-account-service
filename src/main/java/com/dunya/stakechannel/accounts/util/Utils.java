package com.dunya.stakechannel.accounts.util;

import java.util.Date;

import com.dunya.stakechannel.accounts.model.TimePeriod;

public final class Utils {
	private Utils() {
	}

	public static TimePeriod getEpochTimeStampToQuery(Integer days) {
		Date date = new Date();
		TimePeriod period = new TimePeriod();
		long endTime = date.getTime();
		long startTime = endTime - days * 86400000;
		period.setStartTime(startTime);
		period.setEndTime(endTime);
		return period;
	}
}
