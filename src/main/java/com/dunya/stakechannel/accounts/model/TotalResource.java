package com.dunya.stakechannel.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalResource {
	private String owner;
	@JsonProperty("net_weight")
	private String netWeight;
	@JsonProperty("cpu_weight")
	private String cpuWeight;
	@JsonProperty("ram_bytes")
	private String ramBytes;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public String getRamBytes() {
		return ramBytes;
	}

	public void setRamBytes(String ramBytes) {
		this.ramBytes = ramBytes;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TotalResource [owner=");
		builder.append(owner);
		builder.append(", netWeight=");
		builder.append(netWeight);
		builder.append(", cpuWeight=");
		builder.append(cpuWeight);
		builder.append(", ramBytes=");
		builder.append(ramBytes);
		builder.append("]");
		return builder.toString();
	}
	
}
