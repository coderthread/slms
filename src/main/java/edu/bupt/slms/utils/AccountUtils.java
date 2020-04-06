package edu.bupt.slms.utils;

import edu.bupt.slms.bean.Account;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author: 韩 宁
 * @create: 2020/04/05 16:36:23
 */
public class AccountUtils {
    public static Account getCurrentAccount() {
        return ((Account) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
