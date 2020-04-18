package edu.bupt.slms.service.warehouse;

import edu.bupt.slms.bean.WLight;
import edu.bupt.slms.bean.WPole;
import edu.bupt.slms.mapper.WLightMapper;
import edu.bupt.slms.mapper.WPoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseShowService {

    @Autowired
    WLightMapper wLightMapper;
    @Autowired
    WPoleMapper wPoleMapper;

    public List<WLight> getAllLights() {
        return wLightMapper.getAllLights();
    }

    public List<WPole> getAllPoles() {
        return wPoleMapper.getALlPoles();
    }

    public Integer updateLight(WLight wLight) {
        return wLightMapper.updateByPrimaryKeySelective(wLight);
    }

    public Integer updatePole(WPole wPole) {
        return wPoleMapper.updateByPrimaryKeySelective(wPole);
    }

}
