package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.ConstructionBill;

public interface ConstructionBillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstructionBill record);

    int insertSelective(ConstructionBill record);

    ConstructionBill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConstructionBill record);

    int updateByPrimaryKey(ConstructionBill record);
}