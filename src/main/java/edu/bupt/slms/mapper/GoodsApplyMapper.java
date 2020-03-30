package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.GoodsApply;

public interface GoodsApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsApply record);

    int insertSelective(GoodsApply record);

    GoodsApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GoodsApply record);

    int updateByPrimaryKey(GoodsApply record);
}