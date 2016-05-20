package com.webside.member.model;

import java.util.Date;

import com.webside.base.basemodel.BaseEntity;

public class MemberEntity extends BaseEntity{
	
	private static final long serialVersionUID = 4696394027941764613L;

	private String mAccountName;
	
	private String mPassword;
	
	private String mName;
	
	private String mEmail;
	
	private String mPhone;
	
	private Date mRegTime;
	
	private Integer mStatus;
	
	private Integer mIsNew;
	
	private String mCredentialsSalt;
	
	private MemberInfoEntity memberInfo;
	
	private Integer mBcBind;

	public String getmAccountName() {
		return mAccountName;
	}

	public void setmAccountName(String mAccountName) {
		this.mAccountName = mAccountName;
	}
	
	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmEmail() {
		return mEmail;
	}

	public void setmEmail(String mEmail) {
		this.mEmail = mEmail;
	}

	public String getmPhone() {
		return mPhone;
	}

	public void setmPhone(String mPhone) {
		this.mPhone = mPhone;
	}

	public Date getmRegTime() {
		return mRegTime;
	}

	public void setmRegTime(Date mRegTime) {
		this.mRegTime = mRegTime;
	}

	public Integer getmStatus() {
		return mStatus;
	}

	public void setmStatus(Integer mStatus) {
		this.mStatus = mStatus;
	}

	public Integer getmIsNew() {
		return mIsNew;
	}

	public void setmIsNew(Integer mIsNew) {
		this.mIsNew = mIsNew;
	}
	
	public String getmCredentialsSalt() {
		return mCredentialsSalt;
	}

	public void setmCredentialsSalt(String mCredentialsSalt) {
		this.mCredentialsSalt = mCredentialsSalt;
	}
	
	public Integer getmBcBind() {
		return mBcBind;
	}

	public void setmBcBind(Integer mBcBind) {
		this.mBcBind = mBcBind;
	}

	public MemberInfoEntity getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfoEntity memberInfo) {
		this.memberInfo = memberInfo;
	}

	@Override
	public String toString() {
		return "MemberEntity [id="+ id 
				+ ", mAccountName=" + mAccountName 
				+ ", mPassword=" + mPassword 
				+ ", mName=" + mName 
				+ ", mEmail=" + mEmail 
				+ ", mPhone=" + mPhone 
				+ ", mRegTime=" + mRegTime 
				+ ", mStatus=" + mStatus 
				+ ", mIsNew=" + mIsNew
				+ ", memberInfo=" + memberInfo + "]";
	}
	
	

}
