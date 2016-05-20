package com.webside.mguess.service;

import java.util.List;
import java.util.Map;

import com.webside.mguess.model.MGuessEntity;

public interface MGuessService {
	
	public List<MGuessEntity> queryListByPage(Map<String, Object> parameter);
	
    public String queryGuessTotal();
	
	public String queryPledgeTotal();
	
	public String queryAwardTotal();
	
	public String queryMemberTotal();
	
    public String queryPledgeTotalByCondition(Map<String, Object> parameter);
	
	public String queryAwardTotalByCondition(Map<String, Object> parameter);
	
	public String queryManTotalByCondition(Map<String, Object> parameter);
	
}
