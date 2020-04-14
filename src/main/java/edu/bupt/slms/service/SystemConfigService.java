package edu.bupt.slms.service;

import edu.bupt.slms.bean.SystemConfig;
import edu.bupt.slms.mapper.SystemConfigMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 韩 宁
 * @create: 2020/04/13 17:52:57
 */
@Service
public class SystemConfigService {
    @Autowired
    SystemConfigMapper systemConfigMapper;

    public SystemConfig getSystemCfg() {
        return systemConfigMapper.getSystemCfgByEnable();
    }

    public int updateConfigService(SystemConfig systemConfig) {
        return systemConfigMapper.updateByPrimaryKeySelective(systemConfig);
    }
}
