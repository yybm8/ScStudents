package com.yybm8.service;

import com.yybm8.vo.Resgister;
import com.yybm8.vo.Result;

public interface SaLoginService {
    boolean oncelogin(Resgister resgister);

    int selectStudentId(String username);

    Result outMani(int studentId);

    Result addClassOut(int studentId,  int classId,int studentOut);
}
