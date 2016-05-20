package com.webside.mguess.model;

import java.util.Date;

import com.webside.base.basemodel.BaseEntity;
import com.webside.member.model.MemberEntity;

public class MGuessEntity extends BaseEntity{

	private static final long serialVersionUID = 3899183066371933513L;
	
	private Long gpId;
	
	private Date mgTime;
	
	private Integer mgBiPledge;
	
	private Integer mgBiAward;
	
	private Integer mgBiMan;
	
	private Integer mgPredictResult;
	
	private Integer mgResult;
	
	private GuessProjectEntity guessProject;
	
	private GuessProjectInfoEntity guessProjectInfo;
	
	private MemberEntity member;

	public Long getGpId() {
		return gpId;
	}

	public void setGpId(Long gpId) {
		this.gpId = gpId;
	}

	public Date getMgTime() {
		return mgTime;
	}

	public void setMgTime(Date mgTime) {
		this.mgTime = mgTime;
	}

	public Integer getMgBiPledge() {
		return mgBiPledge;
	}

	public void setMgBiPledge(Integer mgBiPledge) {
		this.mgBiPledge = mgBiPledge;
	}

	public Integer getMgBiAward() {
		return mgBiAward;
	}

	public void setMgBiAward(Integer mgBiAward) {
		this.mgBiAward = mgBiAward;
	}

	public Integer getMgBiMan() {
		return mgBiMan;
	}

	public void setMgBiMan(Integer mgBiMan) {
		this.mgBiMan = mgBiMan;
	}

	public Integer getMgPredictResult() {
		return mgPredictResult;
	}

	public void setMgPredictResult(Integer mgPredictResult) {
		this.mgPredictResult = mgPredictResult;
	}

	public Integer getMgResult() {
		return mgResult;
	}

	public void setMgResult(Integer mgResult) {
		this.mgResult = mgResult;
	}

	public GuessProjectEntity getGuessProject() {
		return guessProject;
	}

	public void setGuessProject(GuessProjectEntity guessProject) {
		this.guessProject = guessProject;
	}
	
	public GuessProjectInfoEntity getGuessProjectInfo() {
		return guessProjectInfo;
	}

	public void setGuessProjectInfo(GuessProjectInfoEntity guessProjectInfo) {
		this.guessProjectInfo = guessProjectInfo;
	}

	public MemberEntity getMember() {
		return member;
	}

	public void setMember(MemberEntity member) {
		this.member = member;
	}
	
}
