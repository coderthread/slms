package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.Well;
import edu.bupt.slms.mapper.WellMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public int addWells(@RequestBody String params){
        int i = 0;
        int t = 0;
        int success = 0;
        Well tempWell;

        List<Well> resultList = JSONArray.parseArray(params, Well.class);
        for(i = 0; i < resultList.size(); i++){
            t = wellMapper.insert(resultList.get(i));
            if(t == 1){
                success ++;
            }
        }
        if(success == resultList.size()){
            return 1;
        }
        else{
            return 0;
        }
    }

    @DeleteMapping("/well/{id}")
    public int deleteWell(@PathVariable("id") Integer id){
        return wellMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/well")
    public int updateWell(@RequestBody String params){

        System.out.println(params);
        Well well = JSONObject.parseObject(params, Well.class);
        return wellMapper.updateByPrimaryKey(well);
    }
}
