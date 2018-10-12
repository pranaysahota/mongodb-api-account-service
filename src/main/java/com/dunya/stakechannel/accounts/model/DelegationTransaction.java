package com.dunya.stakechannel.accounts.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "account_delegation_transactions")
public class DelegationTransaction{
	@Indexed
	private String accountName;
	@JsonProperty("tx_id")
	private String txId;
	@JsonProperty("block_num")
	private long blockNumber;
	@JsonProperty("block_time")
	private long blockTime;
	@JsonProperty("action")
	private String action;
	@Indexed
	@JsonProperty("pool_name")
	private String poolName;
	@JsonProperty("eos_delegated_for_cpu")
	private double eosDelegatedForCpu;
	@JsonProperty("eos delegated for net")
	private double eosDelegatedForNet;
	@JsonProperty("eos_undelegated_for_cpu")
	private double eosUnDelegatedForCpu;
	@JsonProperty("eos_undelegated_for_net")
	private double eosUnDelegatedForNet;
	@Indexed
	private long timestamp;

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public long getBlockNumber() {
		return blockNumber;
	}

	public void setBlockNumber(long blockNumber) {
		this.blockNumber = blockNumber;
	}

	public long getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(long blockTime) {
		this.blockTime = blockTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getPoolName() {
		return poolName;
	}

	public void setPoolName(String poolName) {
		this.poolName = poolName;
	}

	public double getEosDelegatedForCpu() {
		return eosDelegatedForCpu;
	}

	public void setEosDelegatedForCpu(double eosDelegatedForCpu) {
		this.eosDelegatedForCpu = eosDelegatedForCpu;
	}

	public double getEosDelegatedForNet() {
		return eosDelegatedForNet;
	}

	public void setEosDelegatedForNet(double eosDelegatedForNet) {
		this.eosDelegatedForNet = eosDelegatedForNet;
	}

	public double getEosUnDelegatedForCpu() {
		return eosUnDelegatedForCpu;
	}

	public void setEosUnDelegatedForCpu(double eosUnDelegatedForCpu) {
		this.eosUnDelegatedForCpu = eosUnDelegatedForCpu;
	}

	public double getEosUnDelegatedForNet() {
		return eosUnDelegatedForNet;
	}

	public void setEosUnDelegatedForNet(double eosUnDelegatedForNet) {
		this.eosUnDelegatedForNet = eosUnDelegatedForNet;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DelegationTransaction [accountName=");
		builder.append(accountName);
		builder.append(", txId=");
		builder.append(txId);
		builder.append(", blockNumber=");
		builder.append(blockNumber);
		builder.append(", blockTime=");
		builder.append(blockTime);
		builder.append(", action=");
		builder.append(action);
		builder.append(", poolName=");
		builder.append(poolName);
		builder.append(", eosDelegatedForCpu=");
		builder.append(eosDelegatedForCpu);
		builder.append(", eosDelegatedForNet=");
		builder.append(eosDelegatedForNet);
		builder.append(", eosUnDelegatedForCpu=");
		builder.append(eosUnDelegatedForCpu);
		builder.append(", eosUnDelegatedForNet=");
		builder.append(eosUnDelegatedForNet);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append("]");
		return builder.toString();
	}

}
