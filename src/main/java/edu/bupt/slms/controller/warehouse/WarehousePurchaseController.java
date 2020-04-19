package edu.bupt.slms.controller.warehouse;

import edu.bupt.slms.bean.PurchaseList;
import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.service.warehouse.WarehousePurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/")
    public List<PurchaseList> getAllPurchaseLists(){
        List<PurchaseList> purchaseLists = warehousePurchaseService.getAllPurchaseLists();
        return purchaseLists;
    }

    @PutMapping("/")
    public int updatePurchaseListById(@RequestBody PurchaseList purchaseLists){
        int result = warehousePurchaseService.updatePurchaseListById(purchaseLists);
        return result;
    }

    @PostMapping("/light")
    public String addLight(@RequestBody WLight wLight){
        int result = warehousePurchaseService.addLight(wLight);
        if(result == 1){
            return "入库成功！";
        }
        return "入库失败";
    }

    @PostMapping("/pole")
    public String addPole(@RequestBody WPole wPole){
        int result = warehousePurchaseService.addPole(wPole);
        if(result == 1){
            return "入库成功！";
        }
        return "入库失败";
    }
}
