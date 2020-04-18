package edu.bupt.slms.controller.warehouse;

import edu.bupt.slms.bean.GoodsApply;
import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.service.warehouse.WarehouseCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/warehouse/checkout")
public class WarehouseCheckoutController {

    @Autowired
    WarehouseCheckoutService warehouseCheckoutService;

    //查询所有申请
    @GetMapping("/")
    public List<GoodsApply> getAllGoodsApplies(){
        List<GoodsApply> goodsApplies = new ArrayList<GoodsApply>();
        goodsApplies = warehouseCheckoutService.getAllGoodsApplies();
        return goodsApplies;
    }

    //审核出库
    @PutMapping("/")
    public RespBean updateGoodsAppliesStatus(@RequestBody GoodsApply goodsApply){
        Integer status = warehouseCheckoutService.updateGoodsAppliesStatus(goodsApply);
        if(status > 0) {
            return RespBean.ok("审核成功，状态更改为审核通过！");
        }else {
            return RespBean.ok("审核失败，出现未知错误！");
        }
    }
}
