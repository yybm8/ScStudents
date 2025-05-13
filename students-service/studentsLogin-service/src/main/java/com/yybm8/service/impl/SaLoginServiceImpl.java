package com.yybm8.service.impl;

import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import com.yybm8.mapper.SaLoginMapper;
import com.yybm8.pojo.Students;
import com.yybm8.service.SaLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        System.out.println(studentId+" "+classId+" "+studentOut);
        return saLoginMapper.addClassOut(studentId,classId,studentOut)?Result.yesWork():Result.noWork();
    }
}
