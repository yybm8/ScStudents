package com.yybm8.controller;

import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import com.yybm8.pojo.Students;
import com.yybm8.service.SaRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/studentsLogin/register")
public class SaRegisterController {
    @Autowired
    private SaRegisterService saRegisterService;
    //普通学生注册接口
    @PostMapping("/register")
    public Result register(@RequestBody Resgister resgister){
        if(resgister.getStudent_username()==null&&resgister.getStudent_password()==null){
            return Result.fail();
        }
        else {
            //姓名重复就不可以注册
            List<Students> stu = saRegisterService.selectStudentUsername();
            for (Students students : stu) {
                if (Objects.equals(students.getStudent_username(), resgister.getStudent_username())) {//equals的比较值相同而非地址相同,类似于==
                    return Result.noRegister();
                }
            }
            return saRegisterService.register(resgister);
        }
    }

}
