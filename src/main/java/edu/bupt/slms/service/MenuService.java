package edu.bupt.slms.service;

import edu.bupt.slms.bean.Menu;
import edu.bupt.slms.mapper.MenuMapper;
import edu.bupt.slms.mapper.MenuRoleMapper;
import edu.bupt.slms.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/03/21 22:59:18
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Autowired
    MenuRoleMapper menuRoleMapper;

    public List<Menu> getAllMenuWithRoles() {
        return menuMapper.getAllMenuWithRoles();
    }

    public List<Menu> getMenuByAId() {

        return menuMapper.getMenuByAId(AccountUtils.getCurrentAccount().getId());
    }

    public List<Menu> getMenus() {
        return menuMapper.getMenus();
    }

    public List<Integer> getMidsByRid(Integer rid) {
        return menuMapper.getMidsByRid(rid);
    }

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.deleteByRid(rid);
        if (mids == null || mids.length == 0){
            return true;
        }
        Integer result = menuRoleMapper.insertRecord(rid,mids);
        return mids.length == result;
    }
}
