package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.WPole;

public interface WPoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WPole record);

    int insertSelective(WPole record);

    WPole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WPole record);

    int updateByPrimaryKey(WPole record);
}