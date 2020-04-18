package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.bean.WPole;

import java.util.List;

public interface WPoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WPole record);

    int insertSelective(WPole record);

    WPole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WPole record);

    int updateByPrimaryKey(WPole record);

    List<WPole> getALlPoles();

    List<WPole> selectAllWPoles();
}