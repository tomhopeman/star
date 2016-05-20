package com.webside.gtype.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webside.base.baseservice.impl.AbstractService;
import com.webside.exception.ServiceException;
import com.webside.gtype.mapper.GTypeMapper;
import com.webside.gtype.model.GTypeEntity;
import com.webside.gtype.service.GTypeService;

@Service("gTypeService")
public class GTypeServiceImpl extends AbstractService<GTypeEntity, Long> implements GTypeService{
	
	@Autowired
	private GTypeMapper gTypeMapper;
	
	@Autowired
	public void setBaseMapper() {
		super.setBaseMapper(gTypeMapper);
	}

	@Override
	public int updateGType(GTypeEntity gTypeEntity) {
		try
		{
			return gTypeMapper.update(gTypeEntity);
		}catch(Exception e)
		{
			throw new ServiceException(e);
		}
	}
	
}
