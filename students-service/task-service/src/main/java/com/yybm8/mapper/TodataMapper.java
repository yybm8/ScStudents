package com.yybm8.mapper;

import com.yybm8.dto.StudentTodata;
import com.yybm8.pojo.Teacher;
import com.yybm8.vo.TodataCommit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TodataMapper {
    List<StudentTodata> selectTodataAll(int id);

    List<TodataCommit> selectTodataCName(int id);

    List<TodataCommit> selectTodataCAll(int id);

    Boolean updatatodataover( @Param("todataId") int todata_id);

    List<Teacher> selectTeacherAll(@Param("id") Integer id,@Param("username")String username,@Param("commit_name")String commit_name,@Param("todata_zongjie")Integer todata_zongjie,@Param("todata_over")Integer todata_over, @Param("page")  Integer page, @Param("pageSize")  Integer pageSize);

    int selectTodataCount(@Param("id") Integer id,@Param("username")String username,@Param("commit_name")String commit_name,@Param("todata_zongjie")Integer todata_zongjie,@Param("todata_over")Integer todata_over);

    List<Teacher> selectAddCommitAll();

    List<Teacher> selectAddStudentAll();
}
