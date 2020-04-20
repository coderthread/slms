package edu.bupt.slms.service;

import edu.bupt.slms.bean.GoodsApply;
import edu.bupt.slms.mapper.GoodsApplyMapper;
import edu.bupt.slms.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/19 18:47:33
 */
@Service
public class GoodsApplyService {
    @Autowired
    GoodsApplyMapper goodsApplyMapper;

    public int goodsApply(GoodsApply goodsApply) {
        goodsApply.setApplyId(AccountUtils.getCurrentAccount().getId());
        goodsApply.setTime(new Date());
        goodsApply.setApplyStatus("待审核");
        return goodsApplyMapper.insertSelective(goodsApply);
    }

    public List<GoodsApply> getGoodsApplies(Integer eId) {
        return goodsApplyMapper.getGoodsApplies(eId);
    }
}
