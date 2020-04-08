package com.liyulin.shading.jdbc.mapper;

import com.liyulin.shading.jdbc.entity.ApiLogEntity;

import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.additional.update.force.UpdateByPrimaryKeySelectiveForceMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.Marker;

@org.apache.ibatis.annotations.Mapper
public interface ApiLogBaseMapper extends Mapper<ApiLogEntity>, IdListMapper<ApiLogEntity, Long>,
		InsertListMapper<ApiLogEntity>, UpdateByPrimaryKeySelectiveForceMapper<ApiLogEntity>, Marker {

}