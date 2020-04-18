package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.ConstructionBill;

import java.util.List;

public interface ConstructionBillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstructionBill record);

    int insertSelective(ConstructionBill record);

    ConstructionBill selectByPrimaryKey(Integer id);

    List<ConstructionBill> selectByAid(Integer id);

    int updateByPrimaryKeySelective(ConstructionBill record);

    int updateByPrimaryKey(ConstructionBill record);
}