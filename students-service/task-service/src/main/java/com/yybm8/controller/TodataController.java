package com.yybm8.controller;


import com.yybm8.feign.LoginFeign;
import com.yybm8.service.TodataService;
import com.yybm8.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/task/todata")
public class TodataController {
    @Autowired
    private TodataService todataService;
    @Qualifier("com.yybm8.feign.LoginFeign")
    @Autowired
    private LoginFeign loginFeign;
    @PostMapping("/todataAll")
    public Result todataAll(){
        Result result = loginFeign.loginId();
        if(result.getCode().equals("4005")){
            int id=(int)result.getData();
            return todataService.todataAll(id);
        }
        else{
            return Result.noLogin();
        }
    }
}
