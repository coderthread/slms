package edu.bupt.slms.config;

import edu.bupt.slms.bean.Menu;
import edu.bupt.slms.bean.Role;
import edu.bupt.slms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/03/21 22:57:55
 */
@Component
public class CustomFilterInvocation implements FilterInvocationSecurityMetadataSource {
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    MenuService menuService;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String needUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> menus = menuService.getAllMenuWithRoles();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(),needUrl)){
                List<Role> roles = menu.getRoles();
                String[] strRoles = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    strRoles[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(strRoles);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
