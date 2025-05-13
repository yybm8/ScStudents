package com.yybm8.feign.back;

import com.yybm8.feign.ParentFeign;
import com.yybm8.vo.Result;
import org.springframework.stereotype.Component;

@Component
public class ParentFeignBack implements ParentFeign {
    @Override
    public Result loginId() {
        return Result.fail();
    }
}
