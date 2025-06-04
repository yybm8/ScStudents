package com.yybm8.mapper;

import com.yybm8.pojo.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SaRegisterMapper {

    boolean register(@Param("student_username") String student_username,@Param("student_password") String student_password);

    List<Students> selectStudentUsername();

}
