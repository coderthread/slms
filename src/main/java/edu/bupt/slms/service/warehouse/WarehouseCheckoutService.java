package edu.bupt.slms.service.warehouse;

import edu.bupt.slms.bean.GoodsApply;
import edu.bupt.slms.mapper.GoodsApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseCheckoutService {

    @Autowired
    GoodsApplyMapper goodsApplyMapper;

    public List<GoodsApply> getAllGoodsApplies(){
        return goodsApplyMapper.getAllGoodsApplies();
    }

    public Integer updateGoodsAppliesStatus(GoodsApply goodsApply) {
        return goodsApplyMapper.updateByPrimaryKeySelective(goodsApply);
    }
}
