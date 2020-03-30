package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.AccountRole;

public interface AccountRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AccountRole record);

    int insertSelective(AccountRole record);

    AccountRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AccountRole record);

    int updateByPrimaryKey(AccountRole record);
}