package edu.bupt.slms.controller.warehouse;

import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.service.warehouse.WarehouseShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/warehouse/show")
public class WarehouseShowController {

    @Autowired
    WarehouseShowService warehouseShowService;

    @GetMapping("/")
    public Map<String, List> getAllGoods(){
        Map<String,List> all = new HashMap<String,List>();
        List<WLight> wLights = warehouseShowService.getAllLights();
        List<WPole> wPoles = warehouseShowService.getAllPoles();
        all.put("lights",wLights);
        all.put("poles",wPoles);
        return all;
    }

    @PutMapping("/light")
    public RespBean updateLight(WLight wLight){
        if(warehouseShowService.updateLight(wLight) == 1){
            return RespBean.ok("编辑成功！");
        }
        return RespBean.error("编辑失败，出现未知错误！");
    }

    @PutMapping("/pole")
    public RespBean updateLight(WPole wPole){
        if(warehouseShowService.updatePole(wPole) == 1){
            return RespBean.ok("编辑成功！");
        }
        return RespBean.error("编辑失败，出现未知错误！");
    }
}
