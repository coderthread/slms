package edu.bupt.slms.service;

import edu.bupt.slms.bean.Account;
import edu.bupt.slms.bean.RespAccount;
import edu.bupt.slms.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/03/19 17:27:47
 */
@Service
public class AccountService implements UserDetailsService {
    @Autowired
    AccountMapper accountMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountMapper.loadUserByUsername(s);
        if (account == null){
            throw new UsernameNotFoundException("用户名不存在，请重新登录！");
        }
        account.setRoles(accountMapper.getRolesById(account.getId()));
        return account;
    }

    public List<RespAccount> getAccountsByRoleNameZh(String nameZh,Account account) {
        return accountMapper.getAccountsByRoleNameZh(nameZh,account);
    }
}
