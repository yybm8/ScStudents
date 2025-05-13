package com.yybm8.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.yybm8.feign.ParentFeign;
import com.yybm8.service.ParentService;
import com.yybm8.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/parent/miss")
public class ParentController {
    @Autowired
    private ParentService parentService;

    @Qualifier("com.yybm8.feign.ParentFeign")
    @Autowired
    private ParentFeign parentFeign;

    //当前登录的家长进接口
    @PostMapping("/ParentId")
    public Result SelectParentId(){
        Result result = parentFeign.loginId();
        if(result.getCode().equals("4005")){
            int id=(int)result.getData();
            return parentService.SelectParentId(id);
        }
        else{
            return Result.noLogin();
        }
    }
    //获取所有家长进言接口
    @PostMapping("/ParentAll")
    public Result SelectParentAll(){
        return parentService.SelectParentAll();
    }
}
