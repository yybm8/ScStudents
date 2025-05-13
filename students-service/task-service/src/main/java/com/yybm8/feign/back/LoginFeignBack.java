package com.yybm8.feign.back;

import com.yybm8.feign.LoginFeign;
import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import org.springframework.stereotype.Component;

@Component
public class LoginFeignBack implements LoginFeign {
    @Override
    public Result loginId() {
        return Result.fail();
    }
}
