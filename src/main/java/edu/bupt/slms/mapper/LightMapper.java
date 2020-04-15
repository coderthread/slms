package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Light;

import java.util.List;

public interface LightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Light record);

    int insertSelective(Light record);

    Light selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Light record);

    int updateByPrimaryKey(Light record);

    List<Light> selectAllLights();
}