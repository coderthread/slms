package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Account;
import edu.bupt.slms.bean.Role;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    Account loadUserByUsername(String s);

    List<Role> getRolesById(Integer id);
}