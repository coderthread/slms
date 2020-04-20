package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.Well;
import edu.bupt.slms.mapper.WellMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/basicData/map")
public class WellController {

    @Autowired
    WellMapper wellMapper;

    @GetMapping("/wells")
    public List<Well> getAllWell(){
        return wellMapper.selectAllWells();
    }

    @GetMapping("/well/{id}")
    public Well getWellById(@PathVariable("id") Integer id){
        return wellMapper.selectByPrimaryKey(id);
    }

    @PostMapping("/well")
    public Map<String, Object> addWells(@RequestBody String params){
        int i = 0;
        int t = 0;
        int success = 0;
        Well temp;
        Map<String, Object> resultRes = new HashMap<>();

        List<Well> resultList = JSONArray.parseArray(params, Well.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = wellMapper.insert(temp);
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

    @DeleteMapping("/well/{id}")
    public int deleteWell(@PathVariable("id") Integer id){
        return wellMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/well")
    public Map<String, Object> updateWell(@RequestBody String params){

        System.out.println(params);
        int i = 0;
        int t = 0;
        int success = 0;
        Well temp;
        Map<String, Object> resultRes = new HashMap<>();

        List<Well> resultList = JSONArray.parseArray(params, Well.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = wellMapper.updateByPrimaryKey(temp);
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
