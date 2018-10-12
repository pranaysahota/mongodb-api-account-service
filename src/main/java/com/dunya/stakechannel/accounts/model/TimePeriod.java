package com.dunya.stakechannel.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimePeriod {
	@JsonProperty("start")
	private long startTime = 0;
	@JsonProperty("end")
	private long endTime = 0;

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TimePeriod [startTime=");
		builder.append(startTime);
		builder.append(", endTime=");
		builder.append(endTime);
		builder.append("]");
		return builder.toString();
	}
}
