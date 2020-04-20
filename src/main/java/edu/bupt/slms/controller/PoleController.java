package edu.bupt.slms.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.bupt.slms.bean.Pole;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.entities.PoleNode;
import edu.bupt.slms.mapper.PoleMapper;
import edu.bupt.slms.mapper.WPoleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/basicData/map")
public class PoleController {

    @Autowired
    PoleMapper poleMapper;

    @Autowired
    WPoleMapper wPoleMapper;

    @GetMapping("/poles")
    public List<PoleNode> getAllPoles() throws ParseException {
        System.out.println("获取灯杆1");
        List<Pole> poles = poleMapper.selectAllPoles();
        List<PoleNode> resultPoles = new ArrayList<>();
        int i;
        WPole wPole;
        Pole pole;
        PoleNode tempNode;
        for(i = 0; i < poles.size(); i++) {
            pole = new Pole();
            tempNode = new PoleNode();
            BeanUtils.copyProperties(poles.get(i), pole);
            pole.setInstall_date(pole.makeDateFormat(pole.getInstall_date()));

            tempNode.setP_id(pole.getId());
            tempNode.setWarehouse_flag(pole.getwId());
            tempNode.setPosition(pole.getPosition());
            tempNode.setLatitude(pole.getLatitude());
            tempNode.setLongitude(pole.getLongitude());
            tempNode.setInstall_date(pole.getInstall_date());

            wPole = wPoleMapper.selectByPrimaryKey(pole.getWpId());
            tempNode.setType(wPole.getType());
            tempNode.setHeight(wPole.getHeight());
            tempNode.setLoad_bearing(wPole.getLoadBearing());
            tempNode.setProduction_date(wPole.makeDateFormat(wPole.getProductionDate()));
            tempNode.setPurchase_date(wPole.makeDateFormat(wPole.getPurchaseDate()));
            tempNode.setLife_time(wPole.getLifeTime());
            tempNode.setManufacturer(wPole.getManufacturer());
            tempNode.setPrice(wPole.getPrice());

            resultPoles.add(tempNode);
        }
        return resultPoles;
    }

    @GetMapping("/pole/{id}")
    public Pole getPoleById(@PathVariable("id") Integer id) throws ParseException {

        Pole result = poleMapper.selectByPrimaryKey(id);
        result.setInstall_date(result.makeDateFormat(result.getInstall_date()));
        System.out.println("id:" + id);
        return result;
    }

    @PostMapping("/pole")
    public Map<String, Object> addPoles(@RequestBody String params){
        int i = 0;
        int t = 0;
        int success = 0;
        Pole temp;
        int lastID = 0;
        Map<String, Object> resultRes = new HashMap<>(); // 返回插入成功的ID列表

        List<Pole> resultList = JSONArray.parseArray(params, Pole.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = poleMapper.insert(temp);
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

    @DeleteMapping("/pole/{id}")
    public int deletePole(@PathVariable("id") Integer id){
        return poleMapper.deleteByPrimaryKey(id);
    }

    @PutMapping("/pole")
    public Map<String, Object> updatePole(@RequestBody String params){

        System.out.println(params);
        int i = 0;
        int t = 0;
        int success = 0;
        Pole temp;
        Map<String, Object> resultRes = new HashMap<>();

        List<Pole> resultList = JSONArray.parseArray(params, Pole.class);
        for(i = 0; i < resultList.size(); i++){
            temp = resultList.get(i);
            t = poleMapper.updateByPrimaryKey(temp);
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
