package com.dunya.stakechannel.accounts.model;

import java.util.List;

public class DelegationTransactionResult {
	private List<DelegationTransaction> delegations;

	public List<DelegationTransaction> getDelegations() {
		return delegations;
	}

	public void setDelegations(List<DelegationTransaction> delegations) {
		this.delegations = delegations;
	}

}
