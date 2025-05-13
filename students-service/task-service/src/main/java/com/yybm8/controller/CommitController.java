package com.yybm8.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.yybm8.dto.StudentCommit;
import com.yybm8.feign.LoginFeign;
import com.yybm8.service.CommitService;
import com.yybm8.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task/commit")
public class CommitController {
    @Autowired
    private CommitService commitService;

    @Qualifier("com.yybm8.feign.LoginFeign")
    @Autowired
    private LoginFeign loginFeign;

    //查询进度接口
    @PostMapping("/commit")
    public Result commitName(){
        Result result = loginFeign.loginId();
        if(result.getCode().equals("4005")){
            int id=(int)result.getData();
            return commitService.commitAll(id);
        }
        else{
            return Result.noLogin();
        }
    }
}
