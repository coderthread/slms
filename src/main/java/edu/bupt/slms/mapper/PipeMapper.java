package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Pipe;

import java.util.List;

public interface PipeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Pipe record);

    int insertSelective(Pipe record);

    Pipe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pipe record);

    int updateByPrimaryKey(Pipe record);

    List<Pipe> selectAllPipes();
}