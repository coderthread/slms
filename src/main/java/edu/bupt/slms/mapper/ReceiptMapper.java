package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Receipt;

public interface ReceiptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Receipt record);

    int insertSelective(Receipt record);

    Receipt selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Receipt record);

    int updateByPrimaryKey(Receipt record);

    int updateByErrorIdSelective(Receipt receipt);
}