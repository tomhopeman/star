package com.webside.member.model;

import com.webside.base.basemodel.BaseEntity;

public class MemberInfoEntity extends BaseEntity{
	
	private static final long serialVersionUID = 8533981269941353901L;

	private Long biTotal;
	
	private Long baoTotal;
	
	private Long biBet;
	
	private Long biWaitCash;
	
	private Long biUsable;
	
	private Long mLevel;
	
	private Long mEmpValue;

	public Long getBiTotal() {
		return biTotal;
	}

	public void setBiTotal(Long biTotal) {
		this.biTotal = biTotal;
	}

	public Long getBaoTotal() {
		return baoTotal;
	}

	public void setBaoTotal(Long baoTotal) {
		this.baoTotal = baoTotal;
	}

	public Long getBiBet() {
		return biBet;
	}

	public void setBiBet(Long biBet) {
		this.biBet = biBet;
	}

	public Long getBiWaitCash() {
		return biWaitCash;
	}

	public void setBiWaitCash(Long biWaitCash) {
		this.biWaitCash = biWaitCash;
	}

	public Long getBiUsable() {
		return biUsable;
	}

	public void setBiUsable(Long biUsable) {
		this.biUsable = biUsable;
	}

	public Long getmLevel() {
		return mLevel;
	}

	public void setmLevel(Long mLevel) {
		this.mLevel = mLevel;
	}

	public Long getmEmpValue() {
		return mEmpValue;
	}

	public void setmEmpValue(Long mEmpValue) {
		this.mEmpValue = mEmpValue;
	}

}
