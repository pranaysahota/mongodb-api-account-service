package com.dunya.stakechannel.accounts.model;

public class Limit {
	private long used;
	private long available;
	private long max;

	public long getUsed() {
		return used;
	}

	public void setUsed(long used) {
		this.used = used;
	}

	public long getAvailable() {
		return available;
	}

	public void setAvailable(long available) {
		this.available = available;
	}

	public long getMax() {
		return max;
	}

	public void setMax(long max) {
		this.max = max;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Limit [used=");
		builder.append(used);
		builder.append(", available=");
		builder.append(available);
		builder.append(", max=");
		builder.append(max);
		builder.append("]");
		return builder.toString();
	}

}
