package edu.bupt.slms.controller;

import edu.bupt.slms.bean.GoodsApply;
import edu.bupt.slms.bean.RespBean;
import edu.bupt.slms.service.GoodsApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/19 18:48:28
 */
@RestController
@RequestMapping("/fault/task")
public class ErrorTaskController {
    @Autowired
    GoodsApplyService goodsApplyService;

    @PostMapping("/goods")
    public RespBean goodsApply(@RequestBody GoodsApply goodsApply) {
        if (goodsApplyService.goodsApply(goodsApply) == 1){
            return RespBean.ok("物资申请以提交");
        }
        return RespBean.error("物资申请失败！");
    }

    @GetMapping("/goods")
    public List<GoodsApply> getGoodsApplies(Integer eId) {
        return goodsApplyService.getGoodsApplies(eId);
    }
}
