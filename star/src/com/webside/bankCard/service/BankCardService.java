package com.webside.bankCard.service;

import java.util.List;
import java.util.Map;

import com.webside.bankCard.model.BankCardEntity;

public interface BankCardService
{

    /**
     * 列表查询方法
     * @param parameters
     * @return
     */
    public List<BankCardEntity> queryListByPage(Map<String, Object> parameters);

    /**
     * 获取所有绑定银行卡数量
     * @return
     */
    public String queryTotalBankCard();

    /**
     * 获取所有绑定银行卡的会员数量
     * @return
     */
    public String queryTotalBingdingMember();
    
}
