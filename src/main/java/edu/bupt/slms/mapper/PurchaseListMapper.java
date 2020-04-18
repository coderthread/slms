package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.PurchaseList;

import java.util.List;

public interface PurchaseListMapper {

    List<PurchaseList> getAllPurchase();

    Integer insertPurchaseList(PurchaseList purchaseList);
}
