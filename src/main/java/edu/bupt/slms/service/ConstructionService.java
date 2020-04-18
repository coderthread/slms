package edu.bupt.slms.service;


import edu.bupt.slms.bean.*;

import edu.bupt.slms.mapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

//施工
@Service

public class ConstructionService {
    @Autowired
    ConstructionBillMapper constructionBillMapper;
    @Autowired
    ConstructionDetailMapper constructionDetailMapper;
    @Autowired
    ConstructionReceiptMapper constructionReceiptMapper;
    @Autowired
    PlanningDocumentMapper planningDocumentMapper;
    @Autowired
    LightsToInstallMapper lightToInstallMapper;
    @Autowired
    LightMapper lightMapper;
    @Autowired
    GoodsApplyMapper goodsApplyMapper;

    //根据用户id返回工程列表
    public List<ConstructionBill> getProjectsByaId(Integer id) {

        return constructionBillMapper.selectByAid(id);
    }

    //根据项目id返回进度列表
    public List<ConstructionDetail> getPlanList(Integer id) {
        return constructionDetailMapper.selectByPid(id);
    }

    //根据项目id返回项目属性
    public ConstructionBill getBillService(Integer id) {
        return constructionBillMapper.selectByPrimaryKey(id);
    }

    //添加进度内容
    public RespBean addPlan(ConstructionDetail constructionDetail) {
        constructionDetailMapper.insertSelective(constructionDetail);
        return RespBean.ok("成功添加进度");

    }
    //添加物资申请
    public RespBean addGoodsList(GoodsApply goodsApply) {
        goodsApplyMapper.insertSelective(goodsApply);
        return RespBean.ok("成功申请物资");

    }
    //根据项目id获取物资申请表
    public List<GoodsApply> getGoods(Integer id){
        return goodsApplyMapper.selectByPro_id(id);
    }

    ////根据项目id下载规划书，也就是返回规划书在服务器里的路径。
    public String download(Integer id){
         PlanningDocument planningDocument = planningDocumentMapper.selectByPrimaryKey(id);
         return planningDocument.getDetails();
    }

    //完成该项目,存入回单，修改与该项目绑定的路灯的状态,改变工单状态。
    public RespBean finish(ConstructionReceipt constructionReceipt){
        constructionReceiptMapper.insertSelective(constructionReceipt);
        Integer pdid = constructionReceipt.getBillid();

        ConstructionBill constructionBill = constructionBillMapper.selectByPrimaryKey(pdid);
        constructionBill.setStatus("已完成");
        constructionBillMapper.updateByPrimaryKey(constructionBill);

        List<LightsToInstall> lights = lightToInstallMapper.selectByPdid(pdid);
        for (int i = 0; i < lights.size(); i++) {
            System.out.println(lights.get(i));
            Integer current = lights.get(i).getId();//获得灯的id
            lightToInstallMapper.deleteByPrimaryKey(current);//删除该项，因为已经安装完成。
            Light light = lightMapper.selectByPrimaryKey(current);
            light.setStatus("关闭");//对于刚完工的灯，设置状态为关闭。
            lightMapper.updateByPrimaryKey(light);
        }

        return RespBean.ok("成功提交回单");

    }


}
