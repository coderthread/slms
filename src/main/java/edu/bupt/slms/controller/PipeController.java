package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.Pipe;
import edu.bupt.slms.mapper.PipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PipeController {

    @Autowired
    PipeMapper pipeMapper;

    @GetMapping("/pipes")
    public List<Pipe> getAllPipes(){
        return pipeMapper.selectAllPipes();
    }

    @GetMapping("/pipe/{id}")
    public Pipe getPipeById(@PathVariable("id") Integer id){
        return pipeMapper.selectByPrimaryKey(id);
    }

    @PostMapping("/pipe")
    public int addPipes(@RequestBody String params){
        int i = 0;
        int t = 0;
        int success = 0;
        Pipe tempPipe;

        List<Pipe> resultList = JSONArray.parseArray(params, Pipe.class);
        for(i = 0; i < resultList.size(); i++){
            t = pipeMapper.insert(resultList.get(i));
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

    @DeleteMapping("/pipe/{id}")
    public int deletePipe(@PathVariable("id") Integer id){
        return pipeMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/pipe")
    public int updatePipe(@RequestBody String params){

        System.out.println(params);
        Pipe pipe = JSONObject.parseObject(params, Pipe.class);
        return pipeMapper.updateByPrimaryKey(pipe);
    }
}
