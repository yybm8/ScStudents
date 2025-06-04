package com.yybm8.service.impl;

import com.yybm8.mapper.ParentMapper;
import com.yybm8.pojo.Parent;
import com.yybm8.service.ParentService;
import com.yybm8.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentMapper parentMapper;

    @Override
    public Result ParentInsert(int parentId, String parentMiss, int id) {
        boolean success = parentMapper.ParentInsert(parentId,parentMiss,id);
        if(success){
            return Result.yesWork();
        }
        else{
            return Result.noWork();
        }
    }

    @Override
    public Result SelectParentId(int id) {
        List<Parent> parents= parentMapper.selectParentId(id);
        if(parents.isEmpty()){
            return Result.noData();
        }
        return Result.success(parents);
    }

    @Override
    public Result SelectParentAll() {
        List<Parent> parents= parentMapper.selectParentAll();
        if(parents.isEmpty()){
            return Result.noData();
        }
        return Result.success(parents);
    }
}
