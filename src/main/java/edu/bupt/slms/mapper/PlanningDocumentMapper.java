package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.PlanningDocument;

import java.util.List;

public interface PlanningDocumentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlanningDocument record);

    int insertSelective(PlanningDocument record);

    PlanningDocument selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlanningDocument record);

    int updateByPrimaryKey(PlanningDocument record);

    List<PlanningDocument> selectAllPlanningDocuments();
}