package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.Light;
import edu.bupt.slms.bean.LightsToInstall;
import edu.bupt.slms.bean.PlanningDocument;
import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.entities.LightNode;
import edu.bupt.slms.mapper.LightMapper;
import edu.bupt.slms.mapper.LightsToInstallMapper;
import edu.bupt.slms.mapper.PlanningDocumentMapper;
import edu.bupt.slms.mapper.WLightMapper;
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

    @PostMapping("/light") // 增加
    public Map<String, Object> addLights(@RequestParam(value = "params",required = false) String params,
                                         @RequestParam(value = "aid",required = false) int aid,
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
        List<Light> resultList = JSONArray.parseArray(params, Light.class);
        planningDocument.setAid(aid);
        planningDocument.setId(0);
        planningDocument.setDetails(file.getOriginalFilename().toLowerCase());
        planningDocumentMapper.insert(planningDocument);

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
    public int updateLight(@RequestBody String params){

        System.out.println(params);
        Light light = JSONObject.parseObject(params, Light.class);
        return lightMapper.updateByPrimaryKey(light);
    }

//    @PostMapping("/addLightMeg") // 规划路灯时增加路灯，增加路灯节点，增加灯杆，填写规划书
//    public int planningLights() {
//
//
//    }
}
