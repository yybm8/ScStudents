package com.yybm8.service.impl;

import com.yybm8.dto.StudentCommit;
import com.yybm8.mapper.CommitMapper;
import com.yybm8.service.CommitService;
import com.yybm8.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitServiceImpl implements CommitService {
    @Autowired
    private CommitMapper commitMapper;
    @Override
    public Result commitAll(int id) {
        List<StudentCommit> studentCommits=commitMapper.selectCommitAll(id);
        if(studentCommits.isEmpty()){
            return Result.noData();
        }
        return Result.success(studentCommits);
    }
}
