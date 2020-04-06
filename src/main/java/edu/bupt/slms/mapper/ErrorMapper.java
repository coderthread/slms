package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Error;

import java.util.List;

public interface ErrorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Error record);

    int insertSelective(Error record);

    Error selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Error record);

    int updateByPrimaryKey(Error record);

    List<Error> getErrorByaId(Integer aId);

    List<Error> getAllErrors();
}