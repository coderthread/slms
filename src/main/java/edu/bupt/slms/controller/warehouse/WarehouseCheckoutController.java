package edu.bupt.slms.controller.warehouse;

import edu.bupt.slms.bean.GoodsApply;
import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.service.warehouse.WarehouseCheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
            return RespBean.ok("审核成功，状态更新为申请通过！");
        }else {
            return RespBean.ok("审核失败，出现未知错误！");
        }
    }

    @PutMapping("/light")
    public RespBean updateLight(@RequestBody WLight wLight){
        WLight wLight1 = warehouseCheckoutService.getLightByType(wLight.getType());
        int number = wLight1.getNumber() - wLight.getNumber();
        if(number > 0){
            wLight1.setNumber(number);
            int result = warehouseCheckoutService.updateWLightByType(wLight1);
            if(result == 1){
                return RespBean.ok("出库成功，库存更新成功！");
            }else {
                return RespBean.error("库存更新失败");
            }
        }
        return RespBean.error("库存不足，请及时采购物资");
    }
    @PutMapping("/pole")
    public RespBean updatePole(@RequestBody WPole wPole){
        System.out.println(wPole.getNumber() + " " + wPole.getType());
        WPole wPole1 = warehouseCheckoutService.getPoleByType(wPole.getType());
        System.out.println(wPole1.getNumber());
        int number = wPole1.getNumber() - wPole.getNumber();
        if(number > 0){
            System.out.println("库存足够");
            wPole1.setNumber(number);
            int result = warehouseCheckoutService.updateWPoleByType(wPole1);
            if(result == 1){
                return RespBean.ok("出库成功，库存更新成功！");
            }else {
                return RespBean.error("库存更新失败");
            }
        }
        return RespBean.error("库存不足，请及时采购物资");
    }
}
