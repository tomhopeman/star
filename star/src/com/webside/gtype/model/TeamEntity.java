package com.webside.gtype.model;

import com.webside.base.basemodel.BaseEntity;

public class TeamEntity extends BaseEntity{

	private static final long serialVersionUID = 5733176059067852457L;
	
	private String tName;
	
	private String tLogo;
	
	private String tRemark;
	
	private String tAgenda;
	
	private Integer tStatus;

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettLogo() {
		return tLogo;
	}

	public void settLogo(String tLogo) {
		this.tLogo = tLogo;
	}

	public String gettRemark() {
		return tRemark;
	}

	public void settRemark(String tRemark) {
		this.tRemark = tRemark;
	}

	public String gettAgenda() {
		return tAgenda;
	}

	public void settAgenda(String tAgenda) {
		this.tAgenda = tAgenda;
	}

	public Integer gettStatus() {
		return tStatus;
	}

	public void settStatus(Integer tStatus) {
		this.tStatus = tStatus;
	}
	
}
