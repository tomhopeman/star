package com.webside.member.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webside.base.baseservice.impl.AbstractService;
import com.webside.exception.ServiceException;
import com.webside.member.mapper.MemberMapper;
import com.webside.member.model.MemberEntity;
import com.webside.member.service.MemberService;

@Service("memberService")
public class MemberServiceImpl extends AbstractService<MemberEntity, Long> implements MemberService{
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(memberMapper);
	}
	
	public int updateMember(MemberEntity memberEntity){
		try
		{
			return memberMapper.update(memberEntity);
		}catch(Exception e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public String queryMemberTotal() {
		return memberMapper.queryMemberTotal();
	}

	@Override
	public String queryBindTotal() {
		return memberMapper.queryBindTotal();
	}
	
}
