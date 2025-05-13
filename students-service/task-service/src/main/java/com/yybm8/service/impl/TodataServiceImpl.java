package com.yybm8.service.impl;

import com.yybm8.dto.StudentCommit;
import com.yybm8.dto.StudentTodata;
import com.yybm8.mapper.TodataMapper;
import com.yybm8.service.TodataService;
import com.yybm8.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodataServiceImpl implements TodataService {
    @Autowired
    private TodataMapper todataMapper;

    @Override
    public Result todataAll(int id) {
        List<StudentTodata> studentTodatas=todataMapper.selectTodataAll(id);
        if(studentTodatas.isEmpty()){
            return Result.noData();
        }
        return Result.success(studentTodatas);
    }
}
