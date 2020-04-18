package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.*;
import edu.bupt.slms.entities.LightNode;
import edu.bupt.slms.mapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LightController {

    @Autowired
    LightMapper lightMapper;

    @Autowired
    WLightMapper wLightMapper;

    @Autowired
    PlanningDocumentMapper planningDocumentMapper;

    @Autowired
    LightsToInstallMapper lightsToInstallMapper;

    @Autowired
    ConstructionBillMapper constructionBillMapper;

    @Autowired
    AccountMapper accountMapper;

    @GetMapping("/originLights")
    public List<Light> getAllOriginLights(){
        return lightMapper.selectAllLights();
    }

    @GetMapping("/lights")
    public List<LightNode> getAllLights() throws ParseException {
        List<Light> lights = lightMapper.selectAllLights();
        List<LightNode> resultLights =  new ArrayList<>();
        int i;
        WLight wLight;
        Light l;
        LightNode tempNode;
        for(i = 0; i < lights.size(); i++) {
            l = new Light();
            tempNode = new LightNode();
            BeanUtils.copyProperties(lights.get(i), l);
            l.setInstall_date(l.makeDateFormat(l.getInstall_date()));
            System.out.println(l.toString());

            tempNode.setL_id(l.getId());
            tempNode.setP_id(l.getpId());
            tempNode.setInstall_date(l.getInstall_date());
            tempNode.setState((String)l.getStatus());
            tempNode.setBrightness(l.getBrightness());
            tempNode.setPower(l.getPower());
            tempNode.setCurrent(l.getCurrent());
            tempNode.setVoltage(l.getVoltage());

            wLight = wLightMapper.selectByPrimaryKey(l.getwLightId());
            tempNode.setType(wLight.getType());
            tempNode.setRated_current(wLight.getCurrent());
            tempNode.setRated_power(wLight.getPower());
            tempNode.setRated_voltage(wLight.getVoltage());
            tempNode.setProduction_date(wLight.makeDateFormat(wLight.getProductionDate()));
            tempNode.setPurchase_date(wLight.makeDateFormat(wLight.getPurchaseDate()));
            tempNode.setLife_time(wLight.getLifeTime());
            tempNode.setManufacturer(wLight.getManufacturer());
            tempNode.setPrice(wLight.getPrice());

            resultLights.add(tempNode);
        }
        return resultLights;
    }

    @GetMapping("/light/{id}")
    public Light getLightById(@PathVariable("id") Integer id) throws ParseException {
        Light result = lightMapper.selectByPrimaryKey(id);
        result.setInstall_date(result.makeDateFormat(result.getInstall_date()));
        System.out.println("id:" + id);
        return result;
    }

//    @PostMapping("/planningDocument") // 增加，同时增加规划文档
//    public Map<String, Object> dealPlanningDocument(@RequestBody String params){
//
//
//    }

    @PostMapping("/light") // 增加，同时增加construction bill
    public Map<String, Object> addLights(@RequestParam(value = "params",required = false) String params,
                                         @RequestParam(value = "c_bill",required = false) String c_bill,
                                         @RequestParam(value = "file",required = false) MultipartFile file){
        int i = 0;
        int t = 0;
        int success = 0;
        Light temp;
        int lastID = 0;
        Map<String, Object> resultRes = new HashMap<>(); // 返回插入成功的ID列表
        PlanningDocument planningDocument = new PlanningDocument();
        LightsToInstall lightsToInstall = new LightsToInstall();
        System.out.println(params);
        System.out.println(c_bill);
        List<Light> resultList = JSONArray.parseArray(params, Light.class);
        ConstructionBill bill = JSONObject.parseObject(c_bill, ConstructionBill.class);
        Account account = accountMapper.selectByPrimaryKey(bill.getAccountid());
        bill.setAccountName(account.getName()); // 此处使用施工队名称而不是username
        bill.setPhone(account.getPhone());
        constructionBillMapper.insert(bill);

        planningDocument.setAid(bill.getAccountid());
        planningDocument.setId(0);
        planningDocument.setDetails(file.getOriginalFilename().toLowerCase());
        planningDocumentMapper.insert(planningDocument);
        System.out.println("pdid:" + planningDocument.getId());

        for(i = 0; i < resultList.size(); i++) {
            temp = resultList.get(i);
            t = lightMapper.insert(temp);
            if(t == 1){
                success ++;
            }
            lastID = temp.getId();
            lightsToInstall.setId(temp.getId());
            lightsToInstall.setPdid(planningDocument.getId());
            lightsToInstallMapper.insert(lightsToInstall);
        }
        if(success == resultList.size()){
            resultRes.put("success", 1);
        }
        else{
            resultRes.put("success", 0);
        }
        resultRes.put("lastID", lastID);
        return resultRes;
    }

    @DeleteMapping("/light/{id}")
    public int deleteLight(@PathVariable("id") Integer id){
        return lightMapper.deleteByPrimaryKey(id);
    }

    //获取路灯控制策略
    @GetMapping("/controlStrategy")
    public void getControlStrategy(){

    }

    @PutMapping("/light") //修改
    public Map<String, Object> updateLight(@RequestBody String params){

        System.out.println(params);
        int i = 0;
        int t = 0;
        int success = 0;
        Light temp;
        Map<String, Object> resultRes = new HashMap<>();

        List<Light> resultList = JSONArray.parseArray(params, Light.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = lightMapper.updateByPrimaryKey(temp);
            if(t == 1){
                success ++;
            }
        }
        if(success == resultList.size()){
            resultRes.put("success", 1);
        }
        else{
            resultRes.put("success", 0);
        }
        return resultRes;
    }

//    @PostMapping("/addLightMeg") // 规划路灯时增加路灯，增加路灯节点，增加灯杆，填写规划书
//    public int planningLights() {
//
//
//    }
}
