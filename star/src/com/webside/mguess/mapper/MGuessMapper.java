package com.webside.mguess.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.webside.base.basemapper.BaseMapper;
import com.webside.mguess.model.MGuessEntity;

@Repository
public interface MGuessMapper extends BaseMapper<MGuessEntity, Long>{
	
	public String queryGuessTotal();
	
	public String queryPledgeTotal();
	
	public String queryAwardTotal();
	
	public String queryMemberTotal();
	
	public String queryPledgeTotalByCondition(Map<String, Object> parameter);
	
	public String queryAwardTotalByCondition(Map<String, Object> parameter);
	
	public String queryManTotalByCondition(Map<String, Object> parameter);

}
