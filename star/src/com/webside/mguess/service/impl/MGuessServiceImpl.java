package com.webside.mguess.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webside.base.baseservice.impl.AbstractService;
import com.webside.mguess.mapper.MGuessMapper;
import com.webside.mguess.model.MGuessEntity;
import com.webside.mguess.service.MGuessService;

@Service("mGuessService")
public class MGuessServiceImpl extends AbstractService<MGuessEntity, Long> implements MGuessService{
	@Autowired
	private MGuessMapper mGuessMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(mGuessMapper);
	}

	@Override
	public String queryGuessTotal() {
		return mGuessMapper.queryGuessTotal();
	}

	@Override
	public String queryPledgeTotal() {
		return mGuessMapper.queryPledgeTotal();
	}

	@Override
	public String queryAwardTotal() {
		return mGuessMapper.queryAwardTotal();
	}

	@Override
	public String queryMemberTotal() {
		return mGuessMapper.queryMemberTotal();
	}

	@Override
	public String queryPledgeTotalByCondition(Map<String, Object> parameter) {
		String result = mGuessMapper.queryPledgeTotalByCondition(parameter);
		if(result == null || "".equals(result)) {
			result = "0";
		}
		return result;
	}

	@Override
	public String queryAwardTotalByCondition(Map<String, Object> parameter) {
		String result = mGuessMapper.queryAwardTotalByCondition(parameter);
		if(result == null || "".equals(result)) {
			result = "0";
		}
		return result;
	}

	@Override
	public String queryManTotalByCondition(Map<String, Object> parameter) {
		String result = mGuessMapper.queryManTotalByCondition(parameter);
		if(result == null || "".equals(result)) {
			result = "0";
		}
		return result;
	}
	
}
