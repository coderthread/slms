package edu.bupt.slms.service.warehouse;

import edu.bupt.slms.bean.GoodsApply;
import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.mapper.GoodsApplyMapper;
import edu.bupt.slms.mapper.WLightMapper;
import edu.bupt.slms.mapper.WPoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseCheckoutService {

    @Autowired
    GoodsApplyMapper goodsApplyMapper;

    @Autowired
    WLightMapper wLightMapper;

    @Autowired
    WPoleMapper wPoleMapper;

    public List<GoodsApply> getAllGoodsApplies(){
        return goodsApplyMapper.getAllGoodsApplies();
    }

    public Integer updateGoodsAppliesStatus(GoodsApply goodsApply) {
        return goodsApplyMapper.updateByPrimaryKeySelective(goodsApply);
    }

    public WLight getLightByType(String type) {
        return wLightMapper.getLightByType(type);
    }

    public Integer updateWLightByType(WLight wLight) {
        return wLightMapper.updateNumberByType(wLight);
    }

    public WPole getPoleByType(String type) {
        return wPoleMapper.getPoleByType(type);
    }

    public Integer updateWPoleByType(WPole wPole1) {
        return wPoleMapper.updateNumberByType(wPole1);
    }
}
