package com.webside.member.service;

import java.util.List;
import java.util.Map;

import com.webside.member.model.MemberEntity;

public interface MemberService {
	public List<MemberEntity> queryListByPage(Map<String, Object> parameter);
	
	public int updateMember(MemberEntity memberEntity);
	
	public MemberEntity findById(Long id);
	
	public MemberEntity findByName(String accountName);
	
	public String queryMemberTotal();
	
	public String queryBindTotal();
	
}
