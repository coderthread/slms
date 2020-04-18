package edu.bupt.slms.controller.warehouse;

import edu.bupt.slms.bean.PurchaseList;
import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.service.warehouse.WarehousePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/warehouse/purchase")
public class WarehousePurchaseController {

    @Autowired
    WarehousePurchaseService warehousePurchaseService;

    @PostMapping("/")
    public String addPurchaseList(@RequestBody PurchaseList purchaseList){
        int result = warehousePurchaseService.addPurchaseList(purchaseList);
        if(result > 0){
            return "添加成功！";
        }
        return "添加失败";
    }
}
