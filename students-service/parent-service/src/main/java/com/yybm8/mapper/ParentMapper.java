package com.yybm8.mapper;

import com.yybm8.pojo.Parent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ParentMapper {
    List<Parent> selectParentId(int id);

    List<Parent> selectParentAll();

    Boolean ParentInsert(@Param( "parent_class") int parentClass,@Param( "parent_miss") String parentMiss,@Param("student_id") int id);
}
