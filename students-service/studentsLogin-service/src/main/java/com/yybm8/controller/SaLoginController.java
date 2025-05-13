package com.yybm8.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import com.yybm8.service.SaLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/studentsLogin")
public class SaLoginController {
    @Autowired
    private SaLoginService saLoginService;

    //登录接口
    @PostMapping("/login")
    public Result oncelogin(@RequestBody Resgister resgister)
    {
        if(resgister.getStudent_username()==null&&resgister.getStudent_password()==null){
            return Result.fail();
        }
        else{
            boolean login = saLoginService.oncelogin(resgister);
            if(login){
                StpUtil.login(saLoginService.selectStudentId(resgister.getStudent_username()));
                return Result.yesLogin(StpUtil.getTokenValue());
            }
            else{
                return Result.noLogin();
            }
        }
    }
    //安全登出接口
    @PostMapping("/outLogin")
    public Result outLogin()
    {
        if(StpUtil.isLogin()){
        StpUtil.logout();
        return Result.yesWork();
        }

        else{
            return Result.noWork();
        }
    }
    //缴费接口
    @PostMapping("/mani")
    public Result outMani(){
        if(!StpUtil.isLogin()){
            return Result.fail();
        }
        else{
            return saLoginService.outMani(StpUtil.getLoginIdAsInt());
        }
    }
    //第一次登录后添加数据接口
    @PostMapping("/addClassOut")
    public Result addClassOut(@RequestBody Resgister resgister)
    {
        if(!StpUtil.isLogin()){
            return Result.fail();
        }
        else{
            int classId=resgister.getClass_id();
            int studentOut=resgister.getStudent_out();
            return saLoginService.addClassOut(StpUtil.getLoginIdAsInt(),classId,studentOut);
        }
    }
    @PostMapping("/loginId")
    public Result loginId()
    {
        return Result.yesLogin(StpUtil.getLoginIdAsInt());
    }


}
