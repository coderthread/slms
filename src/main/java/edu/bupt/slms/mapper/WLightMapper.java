package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.WLight;

import java.util.List;

public interface WLightMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WLight record);

    int insertSelective(WLight record);

    WLight selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WLight record);

    int updateByPrimaryKey(WLight record);

    List<WLight> getAllLights();

    List<WLight> selectAllWLights();
}