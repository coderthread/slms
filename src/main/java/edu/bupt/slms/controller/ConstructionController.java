package edu.bupt.slms.controller;

import edu.bupt.slms.bean.*;
import edu.bupt.slms.bean.Error;
//import edu.bupt.slms.service.ConstructionService;
import edu.bupt.slms.service.ConstructionService;
import edu.bupt.slms.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//施工
@RestController
@RequestMapping("/construction")
public class ConstructionController {
    @Autowired
    ConstructionService constructionService;


    //根据用户id获取项目列表
    @GetMapping("/getProject")
    public List<ConstructionBill> getProjectByPage(Integer id) {
        return constructionService.getProjectsByaId(id);
    }

   //根据项目id返回进度列表
    @GetMapping("/getPlanList")
    public List<ConstructionDetail> getPlanListByPage(Integer id) {
        return constructionService.getPlanList(id);
    }

    //根据项目id返回项目属性
    @GetMapping("/getBill")
    public ConstructionBill getBill(Integer id) {
        return constructionService.getBillService(id);
    }

    //添加进度内容
    @PostMapping("/addPlan/")
    public RespBean addPlan(@RequestBody ConstructionDetail constructionDetail){
        return constructionService.addPlan(constructionDetail);
    }

    //申请物资
    @PostMapping("/addGoodsList/")
    public RespBean addGoodsList(@RequestBody GoodsApply goodsApply){
        System.out.println(goodsApply);
        return constructionService.addGoodsList(goodsApply);
    }

    //根据项目id,获取物资申请表
    @GetMapping("/getGoods")
    public List<GoodsApply> getGoods(Integer id)
    {
        return constructionService.getGoods(id);
    }

    //下载规划书，也就是返回规划书在服务器里的路径。
    @GetMapping("/downloadWord")
    public String downloadWord(Integer id){
        return constructionService.download(id);
    }

    //完成该项目,存入回单，修改与该项目绑定的路灯的状态
    @PostMapping("/finish/")
    public RespBean AddReceipt(@RequestBody ConstructionReceipt constructionReceipt){
        return constructionService.finish(constructionReceipt);

    }
}
