package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.RepairBill;

public interface RepairBillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RepairBill record);

    int insertSelective(RepairBill record);

    RepairBill selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RepairBill record);

    int updateByPrimaryKey(RepairBill record);
}