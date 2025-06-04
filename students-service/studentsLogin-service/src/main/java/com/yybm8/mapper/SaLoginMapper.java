package com.yybm8.mapper;

import com.yybm8.pojo.Classs;
import com.yybm8.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SaLoginMapper {
    int selectStudentId(String username);

    Students oncelogin(@Param("username") String username,@Param("password") String password);

    boolean outMani(int studentId);

    boolean addClassOut(@Param("studentId") int studentId,@Param("classId") int classId,@Param("studentOut") int studentOut);

    int selectClassOut(int loginIdAsInt);

    List<Classs> selectClassAll();

    boolean twoMoni(int studentId);

    int selectStuMode(int  studentId);
}
