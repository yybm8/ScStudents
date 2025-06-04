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
@RequestMapping("/api/studentsLogin/login")
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
                return Result.yesLogin(StpUtil.getTokenInfo());
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
            return Result.noLogin();
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
    //根据当前登录查询缴费信息
    @PostMapping("/selectClassOut")
    public Result selectClassOut(){
        if(!StpUtil.isLogin()){
            System.out.println("未登录");
            return Result.fail();
        }
        else{
            System.out.println("已经登录");
            System.out.println(StpUtil.getLoginIdAsInt());
            return saLoginService.selectClassOut(StpUtil.getLoginIdAsInt());
        }
    }
    //传递登录id信息接口
    @PostMapping("/loginId")
    public Result loginId()
    {
        return Result.yesLogin(StpUtil.getLoginIdAsInt());
    }

    //查询班级所有信息
    @PostMapping("/selectClassAll")
    public Result selectClassAll(){
        return saLoginService.selectClassAll();
    }

    //查询当前登录人员的身份
    @PostMapping("/selectClassMode")
     public Result selectClassMode(){
        if(!StpUtil.isLogin()){
            return Result.fail();
        }
        else{
            return saLoginService.selectStuMode(StpUtil.getLoginIdAsInt());
        }
    }

}
