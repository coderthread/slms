package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.LightToInstall;

import java.util.List;

public interface LightToInstallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LightToInstall record);

    int insertSelective(LightToInstall record);

    LightToInstall selectByPrimaryKey(Integer id);

    List<LightToInstall> selectByPdid(Integer pdid);//根据项目id查找绑定的所有路灯id

    int updateByPrimaryKeySelective(LightToInstall record);

    int updateByPrimaryKey(LightToInstall record);
}