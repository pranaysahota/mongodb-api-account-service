package com.dunya.stakechannel.accounts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DelegationStatus {

	@JsonProperty("account_name")
	private String accountName;
	@JsonProperty("total_eos_delegated_for_cpu")
	private double totalEosDelegatedForCpu;
	@JsonProperty("total_eos_delegated_for_net")
	private double totalEosDelegatedForNet;
	@JsonProperty("total_eos_undelegated_for_cpu")
	private double totalEosUnDelegatedForCpu;
	@JsonProperty("total_eos_undelegated_for_net")
	private double totalEosUnDelegatedForNet;
	@JsonProperty("pool_name")
	private String _id;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getTotalEosDelegatedForCpu() {
		return totalEosDelegatedForCpu;
	}

	public void setTotalEosDelegatedForCpu(double totalEosDelegatedForCpu) {
		this.totalEosDelegatedForCpu = totalEosDelegatedForCpu;
	}

	public double getTotalEosDelegatedForNet() {
		return totalEosDelegatedForNet;
	}

	public void setTotalEosDelegatedForNet(double totalEosDelegatedForNet) {
		this.totalEosDelegatedForNet = totalEosDelegatedForNet;
	}

	public double getTotalEosUnDelegatedForCpu() {
		return totalEosUnDelegatedForCpu;
	}

	public void setTotalEosUnDelegatedForCpu(double totalEosUnDelegatedForCpu) {
		this.totalEosUnDelegatedForCpu = totalEosUnDelegatedForCpu;
	}

	public double getTotalEosUnDelegatedForNet() {
		return totalEosUnDelegatedForNet;
	}

	public void setTotalEosUnDelegatedForNet(double totalEosUnDelegatedForNet) {
		this.totalEosUnDelegatedForNet = totalEosUnDelegatedForNet;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DelegationStatus [accountName=");
		builder.append(accountName);
		builder.append(", totalEosDelegatedForCpu=");
		builder.append(totalEosDelegatedForCpu);
		builder.append(", totalEosDelegatedForNet=");
		builder.append(totalEosDelegatedForNet);
		builder.append(", totalEosUnDelegatedForCpu=");
		builder.append(totalEosUnDelegatedForCpu);
		builder.append(", totalEosUnDelegatedForNet=");
		builder.append(totalEosUnDelegatedForNet);
		builder.append(", _id=");
		builder.append(_id);
		builder.append("]");
		return builder.toString();
	}

}
