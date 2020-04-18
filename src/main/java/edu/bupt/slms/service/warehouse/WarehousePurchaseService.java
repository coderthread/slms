package edu.bupt.slms.service.warehouse;

import edu.bupt.slms.bean.PurchaseList;
import edu.bupt.slms.mapper.PurchaseListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehousePurchaseService {

    @Autowired
    PurchaseListMapper purchaseListMapper;

    public int addPurchaseList(PurchaseList purchaseList){

        return purchaseListMapper.insertPurchaseList(purchaseList);
    }
}
