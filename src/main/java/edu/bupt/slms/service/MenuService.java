package edu.bupt.slms.service;

import edu.bupt.slms.bean.Menu;
import edu.bupt.slms.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/03/21 22:59:18
 */
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenuWithRoles() {
        return menuMapper.getAllMenuWithRoles();
    }
}
