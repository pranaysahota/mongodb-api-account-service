package com.dunya.stakechannel.accounts.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonProperty;


@Document(collection = "accounts")
public class Account {
	@JsonProperty("tx_id")
	private String txId;

	@JsonProperty("creator_account")
	private String creatorAccount;

	@Indexed(unique = true)
	@JsonProperty("account_name")
	private String accountName;

	@JsonProperty("block_time")
	private long blockTime;

	@JsonProperty("block_num")
	private long blockNum;

	private int score;

	private int blacklist;

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	public String getCreatorAccount() {
		return creatorAccount;
	}

	public void setCreatorAccount(String creatorAccount) {
		this.creatorAccount = creatorAccount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public long getBlockTime() {
		return blockTime;
	}

	public void setBlockTime(long blockTime) {
		this.blockTime = blockTime;
	}

	public long getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(long blockNum) {
		this.blockNum = blockNum;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(int blacklist) {
		this.blacklist = blacklist;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [txId=");
		builder.append(txId);
		builder.append(", creatorAccount=");
		builder.append(creatorAccount);
		builder.append(", accountName=");
		builder.append(accountName);
		builder.append(", blockTime=");
		builder.append(blockTime);
		builder.append(", blockNum=");
		builder.append(blockNum);
		builder.append(", score=");
		builder.append(score);
		builder.append(", blacklist=");
		builder.append(blacklist);
		builder.append("]");
		return builder.toString();
	}
}
