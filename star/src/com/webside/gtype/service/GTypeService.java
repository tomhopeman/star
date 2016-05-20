package com.webside.gtype.service;

import java.util.List;
import java.util.Map;

import com.webside.gtype.model.GTypeEntity;
import com.webside.resource.model.ResourceEntity;

public interface GTypeService {
	
	public List<GTypeEntity> queryListByPage(Map<String, Object> parameter);
	
    public int updateGType(GTypeEntity gTypeEntity);
	
	public GTypeEntity findById(Long id);
	
	public int insert(GTypeEntity gTypeEntity);

}
