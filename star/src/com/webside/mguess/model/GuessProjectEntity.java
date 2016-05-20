package com.webside.mguess.model;

import java.util.Date;

import com.webside.base.basemodel.BaseEntity;

public class GuessProjectEntity extends BaseEntity{

	private static final long serialVersionUID = 1973905042489102088L;

	private Long gtId;
	
	private String gpName;
	
	private Long gpTeamA;
	
	private String gpTeamAName;
	
	private Long gpTeamB;
	
	private String gpTeamBName;
	
	private Date gpGameStar;
	
	private Date gpGameEnd;
	
	private Date gpCloseTime;
	
	private Long gpBaseNumber;
	
	private Long gpMultiple;
	
	private Long gpHide;
	
	private Integer gpStatus;
	
	private Integer gpIfRecommend;
	
	private Double gpWinA;
	
	private Double gpWinB;
	
	private Double gpDogfall;
	
	private Double gpManfeeRatio;
	

	public Long getGtId() {
		return gtId;
	}

	public void setGtId(Long gtId) {
		this.gtId = gtId;
	}

	public String getGpName() {
		return gpName;
	}

	public void setGpName(String gpName) {
		this.gpName = gpName;
	}

	public Long getGpTeamA() {
		return gpTeamA;
	}

	public void setGpTeamA(Long gpTeamA) {
		this.gpTeamA = gpTeamA;
	}

	public String getGpTeamAName() {
		return gpTeamAName;
	}

	public void setGpTeamAName(String gpTeamAName) {
		this.gpTeamAName = gpTeamAName;
	}

	public Long getGpTeamB() {
		return gpTeamB;
	}

	public void setGpTeamB(Long gpTeamB) {
		this.gpTeamB = gpTeamB;
	}

	public String getGpTeamBName() {
		return gpTeamBName;
	}

	public void setGpTeamBName(String gpTeamBName) {
		this.gpTeamBName = gpTeamBName;
	}

	public Date getGpGameStar() {
		return gpGameStar;
	}

	public void setGpGameStar(Date gpGameStar) {
		this.gpGameStar = gpGameStar;
	}

	public Date getGpGameEnd() {
		return gpGameEnd;
	}

	public void setGpGameEnd(Date gpGameEnd) {
		this.gpGameEnd = gpGameEnd;
	}

	public Date getGpCloseTime() {
		return gpCloseTime;
	}

	public void setGpCloseTime(Date gpCloseTime) {
		this.gpCloseTime = gpCloseTime;
	}

	public Long getGpBaseNumber() {
		return gpBaseNumber;
	}

	public void setGpBaseNumber(Long gpBaseNumber) {
		this.gpBaseNumber = gpBaseNumber;
	}

	public Long getGpMultiple() {
		return gpMultiple;
	}

	public void setGpMultiple(Long gpMultiple) {
		this.gpMultiple = gpMultiple;
	}

	public Long getGpHide() {
		return gpHide;
	}

	public void setGpHide(Long gpHide) {
		this.gpHide = gpHide;
	}

	public Integer getGpStatus() {
		return gpStatus;
	}

	public void setGpStatus(Integer gpStatus) {
		this.gpStatus = gpStatus;
	}

	public Integer getGpIfRecommend() {
		return gpIfRecommend;
	}

	public void setGpIfRecommend(Integer gpIfRecommend) {
		this.gpIfRecommend = gpIfRecommend;
	}

	public Double getGpWinA() {
		return gpWinA;
	}

	public void setGpWinA(Double gpWinA) {
		this.gpWinA = gpWinA;
	}

	public Double getGpWinB() {
		return gpWinB;
	}

	public void setGpWinB(Double gpWinB) {
		this.gpWinB = gpWinB;
	}

	public Double getGpDogfall() {
		return gpDogfall;
	}

	public void setGpDogfall(Double gpDogfall) {
		this.gpDogfall = gpDogfall;
	}

	public Double getGpManfeeRatio() {
		return gpManfeeRatio;
	}

	public void setGpManfeeRatio(Double gpManfeeRatio) {
		this.gpManfeeRatio = gpManfeeRatio;
	}

}
