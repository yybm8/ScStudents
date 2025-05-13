package com.yybm8.service;

import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;
import com.yybm8.pojo.Students;

import java.util.List;

public interface SaRegisterService {
    Result register(Resgister resgister);

    List<Students> selectStudentUsername();
}
