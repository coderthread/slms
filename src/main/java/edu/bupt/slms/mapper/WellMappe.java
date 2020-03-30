package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Well;

public interface WellMappe {
    int deleteByPrimaryKey(Integer id);

    int insert(Well record);

    int insertSelective(Well record);

    Well selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Well record);

    int updateByPrimaryKey(Well record);
}