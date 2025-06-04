package com.yybm8.service.impl;

import com.yybm8.pojo.Classs;
import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import com.yybm8.mapper.SaLoginMapper;
import com.yybm8.pojo.Students;
import com.yybm8.service.SaLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaLoginServiceImpl implements SaLoginService {
    @Autowired
    private SaLoginMapper saLoginMapper;
    @Override
    public boolean oncelogin(Resgister resgister) {
        String username = resgister.getStudent_username();
        String password = resgister.getStudent_password();
        Students students=saLoginMapper.oncelogin(username,password);
        if(students!=null){
            return true;
        }
        else{return false;}
    }

    @Override
    public int selectStudentId(String username) {
        return saLoginMapper.selectStudentId(username);
    }

    @Override
    public Result outMani(int studentId) {
        return saLoginMapper.outMani(studentId)?Result.yesWork():Result.noWork();
    }

    @Override
    public Result addClassOut(int studentId,int classId,int studentOut) {
        Boolean twoMoni=saLoginMapper.twoMoni(studentId);
        Boolean addClassOut=saLoginMapper.addClassOut(studentId,classId,studentOut);
        if(twoMoni && addClassOut){
            return Result.yesWork();
        }
        else{
            return Result.noWork();
        }
        }

    @Override
    public Result selectClassOut(int loginIdAsInt) {
        return Result.success(saLoginMapper.selectClassOut(loginIdAsInt));
    }

    @Override
    public Result selectClassAll() {
        List<Classs>  classsList=saLoginMapper.selectClassAll();
        if(classsList.isEmpty()){
            return Result.noData();
        }
        else{
            return Result.success(classsList);
        }
    }

    @Override
    public Result selectStuMode(int studentId) {
         return Result.success(saLoginMapper.selectStuMode(studentId));
    }
}
