package com.webside.mguess.model;

import com.webside.base.basemodel.BaseEntity;

public class GuessProjectInfoEntity extends BaseEntity{

	private static final long serialVersionUID = -6269760584042395910L;

	private Integer gpResult;
	
	private Long gpGoalA;
	
	private Long gpGoalB;
	
	private Long biPledgeTotal;
	
	private Long biManTotal;
	
	private Long biAwardTotal;

	public Integer getGpResult() {
		return gpResult;
	}

	public void setGpResult(Integer gpResult) {
		this.gpResult = gpResult;
	}

	public Long getGpGoalA() {
		return gpGoalA;
	}

	public void setGpGoalA(Long gpGoalA) {
		this.gpGoalA = gpGoalA;
	}

	public Long getGpGoalB() {
		return gpGoalB;
	}

	public void setGpGoalB(Long gpGoalB) {
		this.gpGoalB = gpGoalB;
	}

	public Long getBiPledgeTotal() {
		return biPledgeTotal;
	}

	public void setBiPledgeTotal(Long biPledgeTotal) {
		this.biPledgeTotal = biPledgeTotal;
	}

	public Long getBiManTotal() {
		return biManTotal;
	}

	public void setBiManTotal(Long biManTotal) {
		this.biManTotal = biManTotal;
	}

	public Long getBiAwardTotal() {
		return biAwardTotal;
	}

	public void setBiAwardTotal(Long biAwardTotal) {
		this.biAwardTotal = biAwardTotal;
	}

}
