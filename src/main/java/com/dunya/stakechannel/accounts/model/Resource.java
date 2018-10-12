package com.dunya.stakechannel.accounts.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "account_resources")
public class Resource {
	@Indexed
	@JsonProperty("account_name")
	private String accountName;
	@Indexed
	@JsonProperty("timestamp")
	private long timestamp;

	private boolean privileged;

	@JsonProperty("last_code_update")
	private String lastCodeUpdate;

	private String created;

	@JsonProperty("core_liquid_balance")
	private String coreLiquidBalance;

	@JsonProperty("ram_quota")
	private long ramQuota;

	@JsonProperty("net_weight")
	private long netWeight;

	@JsonProperty("cpu_weight")
	private long cpuWeight;

	@JsonProperty("net_limit")
	private Limit netLimit;

	@JsonProperty("cpu_limit")
	private Limit cpuLimit;

	@JsonProperty("ram_usage")
	private long ramUsage;

	@JsonProperty("total_resource")
	private TotalResource totalResource;

	@JsonProperty("self_delegated_bandwidth")
	private SelfDelegatedBandwidth selfDelegatedBandwidth;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isPrivileged() {
		return privileged;
	}

	public void setPrivileged(boolean privileged) {
		this.privileged = privileged;
	}

	public String getLastCodeUpdate() {
		return lastCodeUpdate;
	}

	public void setLastCodeUpdate(String lastCodeUpdate) {
		this.lastCodeUpdate = lastCodeUpdate;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getCoreLiquidBalance() {
		return coreLiquidBalance;
	}

	public void setCoreLiquidBalance(String coreLiquidBalance) {
		this.coreLiquidBalance = coreLiquidBalance;
	}

	public long getRamQuota() {
		return ramQuota;
	}

	public void setRamQuota(long ramQuota) {
		this.ramQuota = ramQuota;
	}

	public long getNetWeight() {
		return netWeight;
	}

	public void setNetWeight(long netWeight) {
		this.netWeight = netWeight;
	}

	public long getCpuWeight() {
		return cpuWeight;
	}

	public void setCpuWeight(long cpuWeight) {
		this.cpuWeight = cpuWeight;
	}

	public Limit getNetLimit() {
		return netLimit;
	}

	public void setNetLimit(Limit netLimit) {
		this.netLimit = netLimit;
	}

	public Limit getCpuLimit() {
		return cpuLimit;
	}

	public void setCpuLimit(Limit cpuLimit) {
		this.cpuLimit = cpuLimit;
	}

	public long getRamUsage() {
		return ramUsage;
	}

	public void setRamUsage(long ramUsage) {
		this.ramUsage = ramUsage;
	}

	public TotalResource getTotalResource() {
		return totalResource;
	}

	public void setTotalResource(TotalResource totalResource) {
		this.totalResource = totalResource;
	}

	public SelfDelegatedBandwidth getSelfDelegatedBandwidth() {
		return selfDelegatedBandwidth;
	}

	public void setSelfDelegatedBandwidth(SelfDelegatedBandwidth selfDelegatedBandwidth) {
		this.selfDelegatedBandwidth = selfDelegatedBandwidth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resource [accountName=");
		builder.append(accountName);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append(", privileged=");
		builder.append(privileged);
		builder.append(", lastCodeUpdate=");
		builder.append(lastCodeUpdate);
		builder.append(", created=");
		builder.append(created);
		builder.append(", coreLiquidBalance=");
		builder.append(coreLiquidBalance);
		builder.append(", ramQuota=");
		builder.append(ramQuota);
		builder.append(", netWeight=");
		builder.append(netWeight);
		builder.append(", cpuWeight=");
		builder.append(cpuWeight);
		builder.append(", netLimit=");
		builder.append(netLimit);
		builder.append(", cpuLimit=");
		builder.append(cpuLimit);
		builder.append(", ramUsage=");
		builder.append(ramUsage);
		builder.append(", totalResource=");
		builder.append(totalResource);
		builder.append(", selfDelegatedBandwidth=");
		builder.append(selfDelegatedBandwidth);
		builder.append("]");
		return builder.toString();
	}
	
}
