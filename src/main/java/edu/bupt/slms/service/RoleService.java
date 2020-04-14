package edu.bupt.slms.service;

import edu.bupt.slms.bean.Role;
import edu.bupt.slms.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/14 14:25:15
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;


    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    public int deleteRole(Integer rid) {
        return roleMapper.deleteByPrimaryKey(rid);
    }

    public int addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")){
            role.setName("ROLE_"+role.getName());
        }
        return roleMapper.insertSelective(role);
    }
}
