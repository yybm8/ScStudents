package com.yybm8.mapper;

import com.yybm8.dto.StudentCommit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommitMapper {
    List<StudentCommit> selectCommitAll(int id);
}
