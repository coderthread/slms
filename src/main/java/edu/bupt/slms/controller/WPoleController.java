package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.mapper.WPoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WPoleController {

    @Autowired
    WPoleMapper wPoleMapper;

    @GetMapping("/wPoles")
    public List<WPole> getAllWPoles(){
        return wPoleMapper.selectAllWPoles();
    }

    @GetMapping("/wPole/{id}")
    public WPole getWPoleById(@PathVariable("id") Integer id) throws ParseException {

        WPole result = wPoleMapper.selectByPrimaryKey(id);
        result.setProductionDate(result.makeDateFormat(result.getProductionDate()));
        result.setPurchaseDate(result.makeDateFormat(result.getPurchaseDate()));
        System.out.println("id:" + id);
        return result;
    }

    @PostMapping("/wPole")
    public Map<String, Object> addWPoles(@RequestBody String params){
        System.out.println(params);
        int i = 0;
        int t = 0;
        int success = 0;
        WPole temp;
        List<Integer> successID =  new ArrayList<>(); // 返回插入成功的ID列表
        Map<String, Object> resultRes = new HashMap<>(); // 返回插入成功的ID列表

        List<WPole> resultList = JSONArray.parseArray(params, WPole.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = wPoleMapper.insert(temp);
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

    @DeleteMapping("/wPole/{id}")
    public int deleteWPole(@PathVariable("id") Integer id){
        return wPoleMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/wPole")
    public int updateWPole(@RequestBody String params){

        System.out.println(params);
        WPole wPole = JSONObject.parseObject(params, WPole.class);
        return wPoleMapper.updateByPrimaryKey(wPole);
    }
}
