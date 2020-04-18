package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.LightsToInstall;

import java.util.List;

public interface LightsToInstallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LightsToInstall record);

    int insertSelective(LightsToInstall record);

    LightsToInstall selectByPrimaryKey(Integer id);

    List<LightsToInstall> selectByPdid(Integer pdid);//根据项目id查找绑定的所有路灯id

    int updateByPrimaryKeySelective(LightsToInstall record);

    int updateByPrimaryKey(LightsToInstall record);

    List<LightsToInstall> selectAllLights();
}