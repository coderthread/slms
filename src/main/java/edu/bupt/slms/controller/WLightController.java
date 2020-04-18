package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.mapper.WLightMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WLightController {

    @Autowired
    WLightMapper wLightMapper;

    @GetMapping("/wLights")
    public List<WLight> getAllWLights(){ return wLightMapper.selectAllWLights(); }

    @GetMapping("/wLight/{id}")
    public WLight getWLightById(@PathVariable("id") Integer id) throws ParseException {

        WLight result = wLightMapper.selectByPrimaryKey(id);
        result.setProductionDate(result.makeDateFormat(result.getProductionDate()));
        result.setPurchaseDate(result.makeDateFormat(result.getPurchaseDate()));
        System.out.println("id:" + id);
        return result;
    }

    @PostMapping("/wLight")
    public Map<String, Object> addWLights(@RequestBody String params){
        System.out.println(params);
        int i = 0;
        int t = 0;
        int success = 0;
        WLight temp;
        System.out.println(params);
        List<Integer> successID =  new ArrayList<>(); // 返回插入成功的ID列表
        Map<String, Object> resultRes = new HashMap<>(); // 返回插入成功的ID列表

        List<WLight> resultList = JSONArray.parseArray(params, WLight.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = wLightMapper.insert(temp);
            if(t == 1){
                success ++;
                successID.add(temp.getId());
            }
        }
        if(success == resultList.size()){
            resultRes.put("success", 1);
        }
        else{
            resultRes.put("success", 0);
        }
        resultRes.put("idList", successID);
        return resultRes;
    }

    @DeleteMapping("/wLight/{id}")
    public int deleteWLight(@PathVariable("id") Integer id){
        return wLightMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/wLight")
    public Map<String, Object> updateWLight(@RequestBody String params){

        System.out.println(params);
        int i = 0;
        int t = 0;
        int success = 0;
        WLight temp;
        Map<String, Object> resultRes = new HashMap<>();

        List<WLight> resultList = JSONArray.parseArray(params, WLight.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = wLightMapper.updateByPrimaryKey(temp);
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
}
