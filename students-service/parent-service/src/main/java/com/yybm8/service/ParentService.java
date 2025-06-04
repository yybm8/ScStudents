package com.yybm8.service;

import com.yybm8.vo.Result;

public interface ParentService {


     Result ParentInsert(int parentClass, String parentMiss, int id);


    Result SelectParentId(int id);

    Result SelectParentAll();
}
