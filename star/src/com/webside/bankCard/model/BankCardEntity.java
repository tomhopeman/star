package com.webside.bankCard.model;

import java.util.Date;

import com.webside.base.basemodel.BaseEntity;

public class BankCardEntity extends BaseEntity
{

    /**
     * 
     */
    private static final long serialVersionUID = 5782552491300395475L;
    
    
    /**
     * 会员ID
     */
    private Long mId;
    
    /**
     * 银行卡号
     */
    private String bcNo;
    
    /**
     * 银行卡姓名
     */
    private String bcName;
    
    /**
     * 开户行省份
     */
    private String bcProvince;
    
    /**
     * 开户行城市
     */
    private String bcCity;
    
    /**
     * 所属银行
     */
    private String bcBank;
    
    /**
     * 绑定时间
     */
    private Date bcBindtime;
    
    /**
     * 状态
     */
    private Integer bcStatus;
    
    /**
     * 关联 会员账号
     */
    private String accountName;
    
    /**
     * 关联 会员姓名
     */
    private String memName;
    
    /**
     * 关联 会员手机号
     */
    private String memPhone;

    public String getMemPhone()
    {
        return memPhone;
    }

    public void setMemPhone(String memPhone)
    {
        this.memPhone = memPhone;
    }

    public String getMemName()
    {
        return memName;
    }

    public void setMemName(String memName)
    {
        this.memName = memName;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public void setAccountName(String accountName)
    {
        this.accountName = accountName;
    }


    public Integer getBcStatus()
    {
        return bcStatus;
    }

    public void setBcStatus(Integer bcStatus)
    {
        this.bcStatus = bcStatus;
    }

    public Long getmId()
    {
        return mId;
    }

    public void setmId(Long mId)
    {
        this.mId = mId;
    }

    public String getBcNo()
    {
        return bcNo;
    }

    public void setBcNo(String bcNo)
    {
        this.bcNo = bcNo;
    }

    public String getBcName()
    {
        return bcName;
    }

    public void setBcName(String bcName)
    {
        this.bcName = bcName;
    }

    public String getBcProvince()
    {
        return bcProvince;
    }

    public void setBcProvince(String bcProvince)
    {
        this.bcProvince = bcProvince;
    }

    public String getBcCity()
    {
        return bcCity;
    }

    public void setBcCity(String bcCity)
    {
        this.bcCity = bcCity;
    }

    public String getBcBank()
    {
        return bcBank;
    }

    public void setBcBank(String bcBank)
    {
        this.bcBank = bcBank;
    }

    public Date getBcBindtime()
    {
        return bcBindtime;
    }

    public void setBcBindtime(Date bcBindtime)
    {
        this.bcBindtime = bcBindtime;
    }
    
    
}
