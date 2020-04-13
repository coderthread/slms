package edu.bupt.slms.mapper;

import edu.bupt.slms.bean.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);

    List<Menu> getAllMenuWithRoles();

    List<Menu> getMenuByAId(Integer id);
}