package com.webside.gtype.model;

import java.util.List;

import com.webside.base.basemodel.BaseEntity;
import com.webside.user.model.UserEntity;

public class GTypeEntity extends BaseEntity{

	private static final long serialVersionUID = -4987527756245730429L;

	private String gtName;
	
	private Integer gtStatus;
	
	private Integer gtType;
	
	private List<TeamEntity> teamList;

	public String getGtName() {
		return gtName;
	}

	public void setGtName(String gtName) {
		this.gtName = gtName;
	}

	public Integer getGtStatus() {
		return gtStatus;
	}

	public void setGtStatus(Integer gtStatus) {
		this.gtStatus = gtStatus;
	}

	public Integer getGtType() {
		return gtType;
	}

	public void setGtType(Integer gtType) {
		this.gtType = gtType;
	}

	public List<TeamEntity> getTeamList() {
		return teamList;
	}

	public void setTeamList(List<TeamEntity> teamList) {
		this.teamList = teamList;
	}
	
}
