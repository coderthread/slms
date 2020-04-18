package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.Pipe;
import edu.bupt.slms.bean.Well;
import edu.bupt.slms.mapper.PipeMapper;
import edu.bupt.slms.mapper.WellMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PipeController {

    @Autowired
    PipeMapper pipeMapper;

    @Autowired
    WellMapper wellMapper;

    @GetMapping("/pipes")
    public List<Pipe> getAllPipes(){
        return pipeMapper.selectAllPipes();
    }

    @GetMapping("/pipe/{id}")
    public Pipe getPipeById(@PathVariable("id") Integer id){
        return pipeMapper.selectByPrimaryKey(id);
    }

    @PostMapping("/pipe")
    public Map<String, Object> addPipes(@RequestBody String params){
        int i = 0;
        int t = 0;
        int success = 0;
        int lastID = 0;
        Pipe temp;
        Map<String, Object> resultRes = new HashMap<>();

        List<Pipe> resultList = JSONArray.parseArray(params, Pipe.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = pipeMapper.insert(temp);
            if(t == 1){
                success ++;
            }
            lastID = temp.getId();
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

    @DeleteMapping("/pipe/{id}") // 删除管孔后，在管孔上的井ppid设为0
    public int deletePipe(@PathVariable("id") Integer id){

        List<Well> wells = wellMapper.selectByPPID(id);
        Well w;
        int i;
        for (i = 0; i < wells.size(); i++) {
            w = wells.get(i);
            w.setPp_id(0);
            wellMapper.updateByPrimaryKey(w);
        }
        return pipeMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/pipe")
    public Map<String, Object> updatePipe(@RequestBody String params){

        System.out.println(params);
        int i = 0;
        int t = 0;
        int success = 0;
        Pipe temp;
        Map<String, Object> resultRes = new HashMap<>();

        List<Pipe> resultList = JSONArray.parseArray(params, Pipe.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = pipeMapper.updateByPrimaryKey(temp);
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
