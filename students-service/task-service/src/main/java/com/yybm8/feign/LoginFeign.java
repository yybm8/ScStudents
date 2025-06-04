package com.yybm8.feign;

import cn.dev33.satoken.stp.StpUtil;
import com.yybm8.feign.back.LoginFeignBack;
import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="studentsLogin-service",fallback = LoginFeignBack.class)
public interface LoginFeign {
    @PostMapping("/api/studentsLogin/login/loginId")
    Result loginId();
}
