package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.GoodsApply;

import java.util.List;

public interface GoodsApplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GoodsApply record);

    int insertSelective(GoodsApply record);

    GoodsApply selectByPrimaryKey(Integer id);

    List<GoodsApply> selectByPro_id(Integer id);

    int updateByPrimaryKey(GoodsApply record);

    List<GoodsApply> getAllGoodsApplies();

    Integer updateByPrimaryKeySelective(GoodsApply record);
}