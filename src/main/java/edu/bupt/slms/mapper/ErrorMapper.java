package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Error;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ErrorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Error record);

    int insertSelective(Error record);

    Error selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Error record);

    int updateByPrimaryKey(Error record);

    List<Error> getErrorByaId(Integer aId);

    long getTotal(@Param("part") Boolean part,@Param("error") Error error, @Param("dateScope") Date[] dateScope);

    List<Error> getErrorByPage(@Param("part") Boolean part,@Param("page") Integer page, @Param("size") Integer size, @Param("error") Error error,
                               @Param("dateScope") Date[] dateScope);

    List<Error> getTasksWithAId(Integer aId);

    List<Error> getHistoryTasksWithAId(Integer aId);
}