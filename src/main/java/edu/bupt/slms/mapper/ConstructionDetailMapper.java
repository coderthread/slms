package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.ConstructionDetail;

public interface ConstructionDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstructionDetail record);

    int insertSelective(ConstructionDetail record);

    ConstructionDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConstructionDetail record);

    int updateByPrimaryKey(ConstructionDetail record);
}