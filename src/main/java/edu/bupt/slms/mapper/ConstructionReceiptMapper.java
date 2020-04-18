package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.ConstructionReceipt;

public interface ConstructionReceiptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstructionReceipt record);

    int insertSelective(ConstructionReceipt record);

    ConstructionReceipt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConstructionReceipt record);

    int updateByPrimaryKey(ConstructionReceipt record);
}