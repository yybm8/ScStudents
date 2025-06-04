package com.yybm8.mapper;

import com.yybm8.dto.StudentCommit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommitMapper {
    List<StudentCommit> selectCommitAll(int id);

    Boolean updatatodatafile(@Param("todataId")int todataId,@Param("filePath") String filePath);
}
