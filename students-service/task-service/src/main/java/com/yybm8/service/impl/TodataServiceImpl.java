package com.yybm8.service.impl;

import com.yybm8.dto.StudentTodata;
import com.yybm8.mapper.TodataMapper;
import com.yybm8.pojo.Teacher;
import com.yybm8.service.TodataService;
import com.yybm8.vo.Result;
import com.yybm8.vo.TodataCommit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Result todataCName(int id) {
        List<TodataCommit> todataCommits=todataMapper.selectTodataCName(id);
        if(todataCommits.isEmpty()){
            return Result.noData();
        }
        return Result.success(todataCommits);
    }

    @Override
    public Result todataCAll(int id) {
        List<TodataCommit> todataCommits=todataMapper.selectTodataCAll(id);
        if(todataCommits.isEmpty()){
            return Result.noData();
        }
        return Result.success(todataCommits);
    }

    @Override
    public Result todataId( int todataId) {
        Boolean b= todataMapper.updatatodataover(todataId);
         if(b){
            return Result.yesWork();
        }
         return Result.noWork();
    }

     @Override

    public Result selectTodataAll(Integer id,String username,String commit_name,Integer todata_zongjie,Integer todata_over,Integer page,Integer pageSize) {
        page=(page-1)*pageSize;
        List<Teacher> teachers=todataMapper.selectTeacherAll(id,username, commit_name,todata_zongjie,todata_over,page,pageSize);
        int count=todataMapper.selectTodataCount(id,username, commit_name,todata_zongjie,todata_over);
         Map m= new HashMap();
          m.put("count",count);
          m.put("data",teachers);
         if(teachers.isEmpty()){
            return Result.noData();
        }
         else{
              return Result.success(m);
         }
    }

    @Override
    public Result selectAddTeacherAll() {
       Map m=new HashMap();
       List<Teacher> commit=todataMapper.selectAddCommitAll();
        List<Teacher> student=todataMapper.selectAddStudentAll();
        m.put("commit",commit);
        m.put("student",student);
        if(commit.isEmpty()&&student.isEmpty()){
            return Result.noData();
        }
        return Result.success(m);

    }
}
