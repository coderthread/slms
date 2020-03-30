package edu.bupt.slms.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author: 韩 宁
 * @create: 2020/03/22 08:12:45
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
//        获取用户有的角色
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        遍历url所需要的的角色
        for (ConfigAttribute attribute : collection) {
            if ("ROLE_LOGIN".equals(attribute.getAttribute())){
//                对于登录后就能访问的资源，若没有登录，提示登录，若登录了，则直接返回
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请登录！");
                } else {
                    return;
                }
            } else {
//                遍历用户拥有的角色，看是否能与url所需的角色匹配上
                for (GrantedAuthority authority : authorities) {
                    if (authority.getAuthority().equals(attribute.getAttribute())){
                        return;
                    }
                }
            }
        }
        throw new AccessDeniedException("您的权限不足，请联系管理员!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
