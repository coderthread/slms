package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.AccountWarehouse;

public interface AccountWarehouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountWarehouse record);

    int insertSelective(AccountWarehouse record);

    AccountWarehouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountWarehouse record);

    int updateByPrimaryKey(AccountWarehouse record);
}