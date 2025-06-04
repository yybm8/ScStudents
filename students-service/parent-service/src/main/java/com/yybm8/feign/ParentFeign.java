package com.yybm8.feign;


import com.yybm8.feign.back.ParentFeignBack;
import com.yybm8.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "studentsLogin-service",fallback = ParentFeignBack.class)
public interface ParentFeign {
    @PostMapping("/api/studentsLogin/login/loginId")
    Result loginId();

}
