package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Account;
import edu.bupt.slms.bean.RespAccount;
import edu.bupt.slms.bean.Role;
import org.apache.ibatis.annotations.Param;

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

    List<RespAccount> getAccountsByRoleNameZh(@Param("nameZh") String nameZh,@Param("account") Account account);
}