package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.ConstructionBill;
import edu.bupt.slms.bean.Pole;

import java.util.List;

import java.util.List;

public interface ConstructionBillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConstructionBill record);

    int insertSelective(ConstructionBill record);

    ConstructionBill selectByPrimaryKey(Integer id);

    List<ConstructionBill> selectByAid(Integer id);

    int updateByPrimaryKeySelective(ConstructionBill record);

    int updateByPrimaryKey(ConstructionBill record);

    List<Pole> selectAllBills();
}