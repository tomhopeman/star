package com.webside.member.mapper;

import org.springframework.stereotype.Repository;

import com.webside.base.basemapper.BaseMapper;
import com.webside.member.model.MemberEntity;

@Repository
public interface MemberMapper extends BaseMapper<MemberEntity, Long>{
	
    public String queryMemberTotal();

    public String queryBindTotal();
}
