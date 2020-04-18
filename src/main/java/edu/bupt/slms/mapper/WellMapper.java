package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Well;

import java.util.List;

public interface WellMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Well record);

    int insertSelective(Well record);

    Well selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Well record);

    int updateByPrimaryKey(Well record);

    List<Well> selectAllWells();
}