package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.WLight;

public interface WLightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WLight record);

    int insertSelective(WLight record);

    WLight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WLight record);

    int updateByPrimaryKey(WLight record);
}