package edu.bupt.slms.service.warehouse;

import edu.bupt.slms.bean.PurchaseList;
import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.mapper.PurchaseListMapper;
import edu.bupt.slms.mapper.WLightMapper;
import edu.bupt.slms.mapper.WPoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehousePurchaseService {

    @Autowired
    PurchaseListMapper purchaseListMapper;

    @Autowired
    WLightMapper wLightMapper;

    @Autowired
    WPoleMapper wPoleMapper;

    public int addPurchaseList(PurchaseList purchaseList){

        return purchaseListMapper.insertPurchaseList(purchaseList);
    }

    public List<PurchaseList> getAllPurchaseLists() {
        return purchaseListMapper.getAllPurchase();
    }

    public int updatePurchaseListById(PurchaseList purchaseLists) {
        return purchaseListMapper.updatePurchaseById(purchaseLists);
    }

    public int addLight(WLight wLight) {
        wLight.setCapacity(500);
        return wLightMapper.insertSelective(wLight);
    }

    public int addPole(WPole wPole) {
        wPole.setCapacity(200);
        return wPoleMapper.insertSelective(wPole);
    }
}
