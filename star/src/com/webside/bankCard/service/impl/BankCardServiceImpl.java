package com.webside.bankCard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webside.bankCard.mapper.BankCardMapper;
import com.webside.bankCard.model.BankCardEntity;
import com.webside.bankCard.service.BankCardService;
import com.webside.base.baseservice.impl.AbstractService;

@Service("bankCardService")
public class BankCardServiceImpl extends AbstractService<BankCardEntity, Long> implements
        BankCardService
{
    @Autowired
    private BankCardMapper bankCardMapper;
    
    @Autowired
    public void setBaseMapper() {
        super.setBaseMapper(bankCardMapper);
    }

    /**
     * 获取所有绑定银行卡数量
     * @return
     */
    @Override
    public String queryTotalBankCard()
    {
        return bankCardMapper.queryTotalBankCard();
    }

    /**
     * 获取所有绑定银行卡的会员数量
     * @return
     */
    @Override
    public String queryTotalBingdingMember()
    {
        return bankCardMapper.queryTotalBingdingMember();
    }
    
}
