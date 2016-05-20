package com.webside.bankCard.mapper;

import org.springframework.stereotype.Repository;

import com.webside.bankCard.model.BankCardEntity;
import com.webside.base.basemapper.BaseMapper;

@Repository
public interface BankCardMapper extends BaseMapper<BankCardEntity, Long>
{

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
