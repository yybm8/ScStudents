package com.yybm8.mapper;

import com.yybm8.dto.StudentTodata;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodataMapper {
    List<StudentTodata> selectTodataAll(int id);
}
