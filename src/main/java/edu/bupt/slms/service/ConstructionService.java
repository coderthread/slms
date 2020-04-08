package edu.bupt.slms.service;


import edu.bupt.slms.bean.*;

import edu.bupt.slms.mapper.ConstructionBillMapper;
import edu.bupt.slms.mapper.ConstructionDetailMapper;
import edu.bupt.slms.mapper.ConstructionReceiptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.Error;
import java.util.Date;
import java.util.List;


@Service
public class ConstructionService {
    @Autowired
    ConstructionBillMapper constructionBillMapper;
    @Autowired
    ConstructionDetailMapper constructionDetailMapper;
    @Autowired
    ConstructionReceiptMapper constructionReceiptMapper;

    //根据用户id返回工程列表
    public List<ConstructionBill> getProjectsByaId(Integer id) {
        return constructionBillMapper.selectByAid(id);
    }

    //根据项目id返回进度列表
    public List<ConstructionDetail> getPlanList(Integer id) {
        return constructionDetailMapper.selectByPid(id);
    }

    //添加进度内容
    public RespBean addPlan(ConstructionDetail constructionDetail) {
        constructionDetailMapper.insertSelective(constructionDetail);
        return RespBean.ok("成功添加进度");

    }

    ////根据项目id下载规划书，也就是返回规划书在服务器里的路径。
    public String download(Integer id){
        return "ssqwuwu";
    }

    //完成该项目,存入回单，修改与该项目绑定的路灯的状态
    public RespBean finish(ConstructionReceipt constructionReceipt){
        constructionReceiptMapper.insertSelective(constructionReceipt);
        return RespBean.ok("成功提交回单");

    }


}
