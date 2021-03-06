package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Pole;

import java.util.List;

public interface PoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pole record);

    int insertSelective(Pole record);

    Pole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pole record);

    int updateByPrimaryKey(Pole record);

    List<Pole> selectAllPoles();
}