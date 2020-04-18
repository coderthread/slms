package edu.bupt.slms.service;


import edu.bupt.slms.bean.Light;
import edu.bupt.slms.mapper.LightMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class LightSchedule {

    @Autowired
    LightMapper lightMapper;

    @Async
    @Scheduled(fixedDelay = 15000)  //间隔15秒更改一次数据库路灯亮度
    public void strategy1() throws InterruptedException {
        List<Light> old = lightMapper.selectAllLights();
        int i;
        Light temp;
        // 更改所有节点亮度，每次加一
        for (i = 0; i < old.size(); i++) {
            temp = new Light();
            BeanUtils.copyProperties(old.get(i), temp);
            if(temp.getBrightness() == 5) {
                temp.setBrightness(1);
            }
            else{
                temp.setBrightness(temp.getBrightness() + 1);
            }
            old.set(i, temp);
            lightMapper.updateByPrimaryKey(old.get(i));
            System.out.println(old.get(i));
        }
    }
}
