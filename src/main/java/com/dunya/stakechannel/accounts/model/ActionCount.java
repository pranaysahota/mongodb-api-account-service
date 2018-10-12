package com.dunya.stakechannel.accounts.model;

public class ActionCount {
	private String action;
	private int count;

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ActionCount [action=" + action + ", count=" + count + "]";
	}
	
}
