package edu.bupt.slms.controller.config;

import edu.bupt.slms.bean.Menu;
import edu.bupt.slms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/10 16:27:41
 */
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenuByAId() {

        return menuService.getMenuByAId();
    }
}
