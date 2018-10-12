package com.dunya.stakechannel.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SelfDelegatedBandwidth {
	private String from;
	private String to;
	@JsonProperty("net_weight")
	private String netWeight;
	@JsonProperty("cpu_weight")
	private String cpuWeight;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(String netWeight) {
		this.netWeight = netWeight;
	}

	public String getCpuWeight() {
		return cpuWeight;
	}

	public void setCpuWeight(String cpuWeight) {
		this.cpuWeight = cpuWeight;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SelfDelegatedBandwidth [from=");
		builder.append(from);
		builder.append(", to=");
		builder.append(to);
		builder.append(", netWeight=");
		builder.append(netWeight);
		builder.append(", cpuWeight=");
		builder.append(cpuWeight);
		builder.append("]");
		return builder.toString();
	}

}
