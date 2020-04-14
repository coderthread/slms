package edu.bupt.slms.controller.account;

import edu.bupt.slms.bean.Menu;
import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.bean.Role;
import edu.bupt.slms.service.MenuService;
import edu.bupt.slms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/14 14:21:19
 */
@RestController
@RequestMapping("/account/auth")
public class AuthorityController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    public List<Menu> getMenus() {
        return menuService.getMenus();
    }

    @GetMapping("/mids/{rid}")
    public List<Integer> getMidsByRid(@PathVariable Integer rid){
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer rid,Integer[] mids){
        if (menuService.updateMenuRole(rid,mids)){
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody Role role){
        if (roleService.addRole(role) == 1){
            return RespBean.ok("添加成功!");
        } else {
            return RespBean.error("添加失败!");
        }
    }

    @DeleteMapping("/role/{rid}")
    public RespBean deleteRole(@PathVariable Integer rid){
        if (roleService.deleteRole(rid) == 1){
            return RespBean.ok("删除成功!");
        } else {
            return RespBean.error("删除失败!");
        }
    }
}
