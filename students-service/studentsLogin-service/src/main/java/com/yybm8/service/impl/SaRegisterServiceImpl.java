package com.yybm8.service.impl;

import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import com.yybm8.mapper.SaRegisterMapper;
import com.yybm8.pojo.Students;
import com.yybm8.service.SaRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaRegisterServiceImpl implements SaRegisterService {
    @Autowired
    private SaRegisterMapper saRegisterMapper;

    @Override
    public Result register(Resgister resgister) {
        String student_username=resgister.getStudent_username();
        String student_password=resgister.getStudent_password();
        return saRegisterMapper.register(student_username,student_password)?Result.yesRegister():Result.noRegister();
    }

    @Override
    public List<Students> selectStudentUsername() {
        return saRegisterMapper.selectStudentUsername();
    }
}
